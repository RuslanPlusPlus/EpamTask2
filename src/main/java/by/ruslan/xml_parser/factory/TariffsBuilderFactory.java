package by.ruslan.xml_parser.factory;

import by.ruslan.xml_parser.builder.AbstractTariffsBuilder;
import by.ruslan.xml_parser.builder.TariffsDomBuilder;
import by.ruslan.xml_parser.builder.TariffsSaxBuilder;
import by.ruslan.xml_parser.builder.TariffsStaxBuilder;

public class TariffsBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private TariffsBuilderFactory(){
    }

    public static AbstractTariffsBuilder createTariffBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM: {
                return new TariffsDomBuilder();
            }
            case SAX: {
                return new TariffsSaxBuilder();
            }
            case STAX: {
                return new TariffsStaxBuilder();
            }
            default:
                throw new EnumConstantNotPresentException(type.getClass(), type.name());
        }
    }
}
