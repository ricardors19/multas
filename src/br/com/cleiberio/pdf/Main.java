package br.com.cleiberio.pdf;

import java.util.ArrayList;

import br.com.cleiberio.pdf.database.Insert;
import br.com.cleiberio.pdf.database.Select;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = 1;

        ArrayList<Objeto> list = new ArrayList<Objeto>();
        PDFReader pdf = new PDFReader();

        pdf.setEnderecoRecurso("http://www.ribeiraopreto.sp.gov.br/transerp/i07radar.pdf");
        String lista = pdf.getConteudo();
        lista = lista.toUpperCase();
        lista = lista.replace("\r", "");
        String[] valor = lista.split("\n");

        while (i < (valor.length - 3)) {
            Objeto ob = new Objeto();
            ob.setRua1(valor[i]);
            ob.setRua2(valor[i + 1]);
            ob.setRua3(valor[i + 2]);
            //ob.setRua4(valor[i + 3]);
            String[] dia = valor[i + 4].split(" ");
            ob.setDia(dia[(dia.length - 1)]);
            ob.setDiaSemana(valor[i + 5]);

            int j = 0;
            while (j < (valor.length)) {
                if (valor[j].contains("RADAR FIXO:")) {
                    ob.setRua4(valor[j]);
                }
                j++;
            }

            list.add(ob);
            i = i + 6;
        }

        String hoje = "29/4/2014";

        for (int j = 1; j < list.size(); j++) {
            //System.out.println(list.get(j).getDia());
            if (list.get(j).getDia().equals(hoje)) {
		//Insert.insert(list.get(j).getRua1(), list.get(j).getDia());
                //Insert.insert(list.get(j).getRua2(), list.get(j).getDia());
                //Insert.insert(list.get(j).getRua3(), list.get(j).getDia());
                //Insert.insert(list.get(j).getRua4(), list.get(j).getDia());

                System.out.println(list.get(j).getDiaSemana() + " " + list.get(j).getDia());
                System.out.println();
                System.out.println(list.get(j).getRua1());
                System.out.println(list.get(j).getRua2());
                System.out.println(list.get(j).getRua3());
                System.out.println(list.get(j).getRua4().replace(" -", "").replace(".", ""));
                System.out.println();

            }
        }
    }

}
