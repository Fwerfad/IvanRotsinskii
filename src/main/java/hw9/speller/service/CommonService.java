package hw9.speller.service;

import hw9.speller.dto.TextDto;

public class CommonService {
    public String getBody(String text) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:spel=\"http://speller.yandex.net/services/spellservice\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <spel:CheckTextRequest lang=\"?\" options=\"0\" format=\"\">\n" +
                "         <spel:text>" + text + "</spel:text>\n" +
                "      </spel:CheckTextRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
    public String getBody(TextDto textDto) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:spel=\"http://speller.yandex.net/services/spellservice\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <spel:CheckTextRequest lang=\"?\" options=\"0\" format=\"\">\n" +
                "         <spel:text>" + textDto.getText() + "</spel:text>\n" +
                "         <spel:lang>" + textDto.getLang() + "</spel:lang>\n" +
                "         <spel:options>" + textDto.getOptions() + "</spel:options>\n" +
                "         <spel:format>" + textDto.getFormat() + "</spel:format>\n" +
                "      </spel:CheckTextRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}
