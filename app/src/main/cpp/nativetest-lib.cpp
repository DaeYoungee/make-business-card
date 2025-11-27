#include <jni.h>

static int g_count = 0;

//extern "C"
//JNIEXPORT jstring JNICALL Java_com_example_businesscard_activity3_Activity3_getNativeTestText(JNIEnv *env, jobject obj) {
//    return env->NewStringUTF("네이티브 함수 호출!");
//}



extern "C" {
// count 값을 1 증가
JNIEXPORT void JNICALL
Java_com_example_businesscard_activity3_Activity3_nativeIncrement(
        JNIEnv *env,
        jobject thiz) {
    g_count += 1;
}

// 현재 count 값을 반환
JNIEXPORT jint JNICALL
Java_com_example_businesscard_activity3_Activity3_nativeGetCount(
        JNIEnv *env,
        jobject thiz) {
    return g_count;
}
}
