package br.com.dio.collection.map;

import java.util.*;

public class DiccionarioEstadoPopulacao {
    public static void main(String[] args) {

        System.out.println("Crie um diccionario e relacione os estados e suas populações: ");
        Map<String, Integer> estadoPopulacaoBrasil = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println("estados com suas populações: " + estadoPopulacaoBrasil);

        System.out.println("Substitua a população do estado do RN por 3.534.165;");
        estadoPopulacaoBrasil.put("RN", 3534165);
        System.out.println("estados com suas populações: " + estadoPopulacaoBrasil);

        System.out.println("=======================================================================");
        System.out.println("Confira se o estado PB está no dicionário, caso não adicione: PB -\n" +
                "                4.039.277;");
        Boolean contemPB = estadoPopulacaoBrasil.containsKey("PB");
        if (!contemPB){
            estadoPopulacaoBrasil.put("PB", 4039277);
        }
        System.out.println("PB está no dicionário: " + estadoPopulacaoBrasil);

        System.out.println("=======================================================================");
        System.out.println(" Exiba a população PE:");
        System.out.println("população PE: " + estadoPopulacaoBrasil.get("PE"));

        System.out.println("=======================================================================");
        System.out.println(" Exiba todos os estados e suas populações na ordem que foi informado");
        Map<String,Integer> estadoPopulacaoBrasil1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};

        System.out.println("Estado - População na ordem que foi informado: " );
        System.out.println(estadoPopulacaoBrasil1);

        System.out.println("=======================================================================");
        System.out.println(" Exiba os estados e suas populações em ordem alfabética");
        Set<Map.Entry<String,Integer>> estadoPopulacaoBrasil2 = new TreeSet<>(new ComparatorEstados());

        estadoPopulacaoBrasil2.addAll(estadoPopulacaoBrasil.entrySet());
        for (Map.Entry<String,Integer> estado: estadoPopulacaoBrasil2){
            System.out.println(estado.getKey() + " - " + estado.getValue());
        }

        System.out.println("=======================================================================");
        System.out.println(" Exiba o estado com o menor população e sua quantidade");

        Integer menorPopulacao = Collections.min(estadoPopulacaoBrasil.values());
        String estadoMenorPopulacao = " ";
        for (Map.Entry<String,Integer> estado : estadoPopulacaoBrasil.entrySet()){
            if (estado.getValue().equals(menorPopulacao)){
                estadoMenorPopulacao = estado.getKey();
                System.out.println(estado.getKey() + " - " + estado.getValue());
            }

        }

        System.out.println("=======================================================================");
        System.out.println("Exiba o estado com a maior população e sua quantidade");

        Integer maiorPopulacao = Collections.max(estadoPopulacaoBrasil.values());
        String estadoMaiorPopulacao = " ";
        for (Map.Entry<String,Integer> estado : estadoPopulacaoBrasil.entrySet()){
            if (estado.getValue().equals(maiorPopulacao)){
                estadoMaiorPopulacao = estado.getKey();
                System.out.println(estado.getKey() + " - " + estado.getValue());
            }

        }

        System.out.println("=======================================================================");
        System.out.println(" Exiba a soma da população desses estados:");

        Iterator<Integer> iterator = estadoPopulacaoBrasil.values().iterator();
        Integer soma = 0;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("=======================================================================");
        System.out.println("Soma da população desses estados: " + soma);
        System.out.println(" Exiba a média da população deste dicionário de estados:");
        System.out.println("Media : " + (soma/estadoPopulacaoBrasil.size()));

        System.out.println("=======================================================================");
        System.out.println("Remova os estados com a população menor que 4.000.000;: ");

        Iterator<Integer> iterator1 = estadoPopulacaoBrasil.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next() <  4000000) {
                iterator1.remove();
            }
        }
        System.out.println(estadoPopulacaoBrasil);

        System.out.println("=======================================================================");
        System.out.println("Apague o dicionário de estados: ");
        estadoPopulacaoBrasil1.clear();
        System.out.println(estadoPopulacaoBrasil1);
        System.out.println("=======================================================================");
        System.out.println("Confira se o dicionário está vazio:  ");
        System.out.println("o dicionário está vazio?: " + estadoPopulacaoBrasil1.isEmpty());


    }
}

class ComparatorEstados implements Comparator<Map.Entry<String,Integer>>{

    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e1.getValue().compareTo(e2.getValue());
    }
}