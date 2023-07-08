package com.myleetcode.a13adapter;

/**
 * @author eniac555
 * @date 2023/7/8
 * @description: 适配器
 */
public class TranslationAdapter implements TextToSpeech {
    private ChineseTranslationService translationService;

    public TranslationAdapter(ChineseTranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public void play(String text) {
        String toEnglish = translationService.translateToEnglish(text);
        System.out.println("Playing translated text: " + toEnglish);
        // 调用底层英文播报功能进行播放
    }
}
