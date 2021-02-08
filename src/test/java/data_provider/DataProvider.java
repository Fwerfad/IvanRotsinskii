package data_provider;

import hw9.speller.service.Options;
import hw9.speller.dto.TextDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "Options")
    public Iterator<Object> dataProviderOptionsMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setExpectedResult("little").setOptions(Options.IGNORE_DIGITS),
                new TextDto().setText("li1l2t5e").setExpectedResult("").setOptions(Options.IGNORE_DIGITS),
                new TextDto().setText("lilte").setExpectedResult("little").setOptions(Options.IGNORE_URLS),
                new TextDto().setText("lilte.net").setExpectedResult("").setOptions(Options.IGNORE_URLS),
                new TextDto().setText("two to tu").setExpectedResult("tu").setOptions(Options.FIND_REPEAT_WORDS),
                new TextDto().setText("two to tu tu").setExpectedResult("").setOptions(Options.FIND_REPEAT_WORDS),
                new TextDto().setText("москва").setExpectedResult("Москва").setOptions(Options.IGNORE_CAPITALIZATION),
                new TextDto().setText("Москва").setExpectedResult("").setOptions(Options.IGNORE_CAPITALIZATION)));
        return dp.iterator();
    }

    @org.testng.annotations.DataProvider(name = "Format")
    public Iterator<Object> dataProviderFormatMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setFormat("plain"),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setFormat("html"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setFormat("plain"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setFormat("utf-8"),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setEndpoint(2).setFormat("plain"),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setEndpoint(2).setFormat("html"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setEndpoint(2).setFormat("plain"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setEndpoint(2).setFormat("utf-8")));
        return dp.iterator();
    }

    @org.testng.annotations.DataProvider(name = "PositiveOne")
    public Iterator<Object> dataProviderPositiveOneMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setExpectedResult("little"),
                new TextDto().setText("малоко").setExpectedResult("молоко"),
                new TextDto().setText("lilte").setExpectedResult("little").setEndpoint(2),
                new TextDto().setText("малоко").setExpectedResult("молоко").setEndpoint(2)));
        return dp.iterator();
    }

    @org.testng.annotations.DataProvider(name = "PositiveMany")
    public Iterator<Object> dataProviderPositiveManyMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto()
                        .setTexts(new ArrayList<String>(Arrays.asList("lilte", "")))
                        .setExpectedResults(new ArrayList<String>(Arrays.asList("little")))
                        .setEndpoint(2),
                new TextDto()
                        .setTexts(new ArrayList<String>(Arrays.asList("lilte", "lilte",  "")))
                        .setExpectedResults(new ArrayList<String>(Arrays.asList("little", "little")))
                        .setEndpoint(2),
                new TextDto()
                        .setTexts(new ArrayList<String>(Arrays.asList("малоко", "молоко")))
                        .setExpectedResults(new ArrayList<String>(Arrays.asList("молоко")))
                        .setEndpoint(2)));
        return dp.iterator();
    }

    @org.testng.annotations.DataProvider(name = "Language")
    public Iterator<Object> dataProviderLanguageMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little"),
                new TextDto().setText("lilte").setLang("ru").setExpectedResult("little").setUnexpectedResult(true),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко"),
                new TextDto().setText("малоко").setLang("en").setExpectedResult("молоко").setUnexpectedResult(true),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setEndpoint(2),
                new TextDto().setText("lilte").setLang("ru").setExpectedResult("little").setUnexpectedResult(true).setEndpoint(2),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setEndpoint(2),
                new TextDto().setText("малоко").setLang("en").setExpectedResult("молоко").setUnexpectedResult(true).setEndpoint(2)));
        return dp.iterator();
    }
}
