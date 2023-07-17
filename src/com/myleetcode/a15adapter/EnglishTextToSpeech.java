package com.myleetcode.a15adapter;

/**
 * @author eniac555
 * @date 2023/7/8
 * @description: 英文播报系统--实现了目标接口
 */
public class EnglishTextToSpeech implements TextToSpeech {
    @Override
    public void play(String text) {
        System.out.println("Playing English text: " + text);
        // 调用底层英文播报功能进行播放
    }
}
