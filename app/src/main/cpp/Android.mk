# 소스 파일의 위치 지정
LOCAL_PATH := $(call my-dir)

# LOCAL 값 중복 제거
include $(CLEAR_VARS)

# 모듈 이름 지정
LOCAL_MODULE := nativetest-lib

# 소스 파일 지정
LOCAL_SRC_FILES := nativetest-lib.cpp

# 공유 라이브러리로 빌드
include $(BUILD_SHARED_LIBRARY)