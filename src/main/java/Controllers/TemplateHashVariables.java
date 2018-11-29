package Controllers;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Callable;

public class TemplateHashVariables extends Screen{

    private HashMap<String, Callable> functions = new HashMap<>();

    public TemplateHashVariables(){

        if(getCurrentLawsuit() == null)
            setCurrentLawsuit(new LawSuit());

        if(getCurrentLawsuit().getClientByClientId() == null)
            getCurrentLawsuit().setClientByClientId(new Client());

        if(getCurrentLawsuit().getClientByClientId().getAddressByAddressId() == null)
            getCurrentLawsuit().getClientByClientId().setAddressByAddressId(new Address());

        if(getCurrentLawsuit().getClientByClientId().getAddressByAddressId().getCityByCityId() ==  null)
            getCurrentLawsuit().getClientByClientId().getAddressByAddressId().setCityByCityId(new City());

        if(getCurrentLawsuit().getClientByClientId().getAddressByAddressId().getStateByStateId() == null)
            getCurrentLawsuit().getClientByClientId().getAddressByAddressId().setStateByStateId(new State());


        functions.put("NomeCliente", getCurrentLawsuit().getClientByClientId()::getName);
        functions.put("EmailCliente", getCurrentLawsuit().getClientByClientId()::getEmail);
        functions.put("NumeroDocumentoCliente", getCurrentLawsuit().getClientByClientId()::getDocumentNumber);
        functions.put("TelefoneCliente", getCurrentLawsuit().getClientByClientId()::getPhone);
        functions.put("EnderecoLinha1Cliente", getCurrentLawsuit().getClientByClientId().getAddressByAddressId()::getAddress);
        functions.put("EnderecoLinha2Cliente", getCurrentLawsuit().getClientByClientId().getAddressByAddressId()::getAddress2);
        functions.put("BairroCLiente", getCurrentLawsuit().getClientByClientId().getAddressByAddressId()::getDistrict);
        functions.put("CidadeCliente", getCurrentLawsuit().getClientByClientId().getAddressByAddressId().getCityByCityId()::getCity);
        functions.put("EstadoCliente", getCurrentLawsuit().getClientByClientId().getAddressByAddressId().getStateByStateId()::getState);
        functions.put("DataPorExtenso", this::unabbreviatedDate);
        functions.put("DataPorExtensoComDiaDaSemana", this::unabbreviatedDateWithDayOfWeek);

    }

    public  String unabbreviatedDateWithDayOfWeek() {
        return unabbreviatedDate(new Date());
    }

    public  String unabbreviatedDateWithDayOfWeek(Date data){
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
        return formatador.format(data);
    }

    public  String unabbreviatedDate() {
        return unabbreviatedDateWithDayOfWeek(new Date());
    }

    public  String unabbreviatedDate(Date data){
        String dataExtenso = unabbreviatedDateWithDayOfWeek(data);
        int index  = dataExtenso.indexOf(",") + 2;
        int lenght = dataExtenso.length();
        return dataExtenso.substring(index, lenght).toLowerCase();
    }

    public ObservableList<String> getKeys(){

        ObservableList<String> keys = FXCollections.observableArrayList();

        functions.forEach((s, callable) -> keys.add(s));

        return keys;
    }

    public String getValue(String key){
        try{
            return (String) functions.get(key).call();
        }catch (Exception ex){
            return "";
        }
    }

}
