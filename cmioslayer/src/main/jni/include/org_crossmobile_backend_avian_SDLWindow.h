/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_crossmobile_backend_avian_SDLWindow */

#ifndef _Included_org_crossmobile_backend_avian_SDLWindow
#define _Included_org_crossmobile_backend_avian_SDLWindow
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    init
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SDLWindow_init
  (JNIEnv *, jclass, jstring);

/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    setSize
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SDLWindow_setSize
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SDLWindow_destroy
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    getWidth
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getWidth
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    getHeight
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getHeight
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    getPixels
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getPixels
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    getPitch
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_crossmobile_backend_avian_SDLWindow_getPitch
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_crossmobile_backend_avian_SDLWindow
 * Method:    update
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_crossmobile_backend_avian_SDLWindow_update
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif