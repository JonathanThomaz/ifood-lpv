package model;

public class MainFactory {

    public static Object getObject(String state) {
        Object actionObject = null;
        String nomeClasse = state;

        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }

        actionObject = objeto;
        return actionObject;
    }

}
