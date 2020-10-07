package utilities;

public final class Printer {

    public static void insertSuccess(){
        System.out.println("Objeto salvo no banco de dados com sucesso!");
    }

    public static void insertFailure(){
        System.out.println("O objeto não foi salvo no banco de dados.");
    }

    public static void selectSuccess(){
        System.out.println("Objeto recuperado do banco de dados com sucesso!");
    }

    public  static void selectFailure(){
        System.out.println("O objeto não foi recuperado do banco de dados.");
    }

    public static void updateSuccess(){
        System.out.println("O objeto atualizado no banco de dados com sucesso!");
    }

    public static void updateFailure(){
        System.out.println("O objeto não foi atualizado no banco de dados.");
    }

    public static void deleteSuccess(){
        System.out.println("O objeto foi deletado no banco de dados com sucesso!");
    }

    public static void deleteFailure(){
        System.out.println("Objeto não foi deletado do banco de dados.");
    }
}
