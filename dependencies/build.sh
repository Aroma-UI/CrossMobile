#!/bin/bash
set -e

WORKSPACE=${PWD}
AVIAN_SOURCES=${PWD}/third_party/avian
AVIAN_INCLUDE=${PWD}/third_party/avian/include
SDL_SOURCES=${PWD}/third_party/SDL
SDL_INCLUDE=${PWD}/third_party/SDL/include
SKIA_SOURCES=${PWD}/third_party/skia
SKIA_INCLUDE=${PWD}/third_party/skia

BUILD_DIR=${PWD}/build
BUILD_OS=linux
BUILD_ARCH=x86_64
BUILD_MODE=debug
BUILD_CMD="platform=$BUILD_OS arch=$BUILD_ARCH mode=$BUILD_MODE process=compile"
BUILD_TARGET=$BUILD_OS-$BUILD_ARCH-$BUILD_MODE

if [ ! -f "$JAVA_HOME"/include/jni.h ] ; then
    echo "Unable to locate JDK under '$JAVA_HOME'"
    exit 1
fi

JAVA_INCLUDE=$JAVA_HOME/include

# Prepare environment
cd $WORKSPACE
# rm -rf $BUILD_DIR
mkdir -p $BUILD_DIR

cd $SDL_SOURCES
rm -rf build
mkdir -p build
cd build
cmake ../ -DSDL_STATIC=ON -DSDL_SHARED=OFF -G Ninja
ninja -C .
cp libSDL2.a $BUILD_DIR

cd $SKIA_SOURCES
python2 tools/git-sync-deps
bin/gn gen out/Static --args='is_official_build=true cc="clang" cxx="clang++" skia_enable_fontmgr_fontconfig =false skia_use_fontconfig = true skia_use_fontconfig = true skia_use_fonthost_mac = false skia_use_freetype = true skia_use_gl = true skia_use_harfbuzz = false skia_use_icu = false skia_use_libfuzzer_defaults = false skia_use_libgifcodec = false skia_use_libheif = false skia_use_libjpeg_turbo_decode = false skia_use_libjpeg_turbo_encode = false skia_use_libpng_decode = false skia_use_libpng_encode = false skia_use_libwebp_decode = false skia_use_libwebp_encode = false skia_use_system_freetype2 = false skia_use_sfntly = false skia_use_system_libpng = false'
ninja -C out/Static
cp out/Static/libskia.a $BUILD_DIR

# Build avian
cd $AVIAN_SOURCES
make clean
make -j $BUILD_CMD

# Extract Avian bootstrap library
cd $BUILD_DIR
cp $AVIAN_SOURCES/build/$BUILD_TARGET/classpath.jar boot.jar

ar x $AVIAN_SOURCES/build/$BUILD_TARGET/libavian.a
zip -r libavian.a.zip *.o
rm *.o

g++ -Os -I$JAVA_INCLUDE -I$JAVA_INCLUDE/$BUILD_OS -D_JNI_IMPLEMENTATION_ -c ../embedded-jar-main.cpp -o main.o
export AROMA_DEPENDENCIES=${PWD}