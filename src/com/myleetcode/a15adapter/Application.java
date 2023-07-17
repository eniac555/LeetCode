package com.myleetcode.a15adapter;

/**
 * @author eniac555
 * @date 2023/7/8
 * @description:
 */
public class Application {
    public static void main(String[] args) {
        EnglishTextToSpeech englishTextToSpeech = new EnglishTextToSpeech();
        englishTextToSpeech.play("原始服务");

        //应用适配器
        TranslationAdapter translationAdapter = new TranslationAdapter(new ChineseTranslationService());
        translationAdapter.play("新服务");

        ChineseTranslationService service = new ChineseTranslationService();
        String s = service.translateToEnglish("不用适配器");
        englishTextToSpeech.play(s);
    }
}
