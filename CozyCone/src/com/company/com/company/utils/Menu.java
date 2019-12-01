package com.company.com.company.utils;

import com.company.com.company.models.Carro;
import com.company.com.company.enums.ETipoCone;

import java.util.Scanner;

public class Menu
{
    private static final Scanner scan = new Scanner(System.in);
    private static CozyConeHotel hotel = CozyConeHotel.getHotel();

    public void menuAplicacao()
    {
        int opcao = 0;
        do
        {
            System.out.println("\n1 - Check-in ");
            System.out.println("2 - Check-out ");
            System.out.println("3 - Listar opções e preços");
            System.out.println("0 - Sair ");

            opcao = receberInt("\nDigite a opcao desejada:");

            Carro carro = new Carro(Carro.gerarModeloCarro(), Carro.gerarCorCarro());
            System.out.println("\nCarro: " + carro.getModelo() + " - " + carro.getCor() + "\n");
            hotel.adicionarCarro(carro);

            switch (opcao)
            {
                case 1:
                    int opcaoTipoCone = receberInt("\nQual tipo de cone voce deseja?\n1 - Cone Simples\n2 - Cone Com Varanda");
                    if(opcaoTipoCone > 0 && opcaoTipoCone < 3)
                    {
                        if(opcaoTipoCone == 1)
                            hotel.realizarCheckIn(carro, ETipoCone.ConeSimples);
                        else
                            hotel.realizarCheckIn(carro, ETipoCone.ConeComVaranda);
                    }
                    break;
                case 2:
                    hotel.realizarCheckOut();
                    break;
                case 3:
                    listarPrecos();
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        } while (opcao != 0);
    }

    private void listarPrecos()
    {
        System.out.println("\n\nCone Simples:\t\t R$480,00");
        System.out.println("Cone Com Varanda:\t\t R$620,00");
        System.out.println("\nCafé da manhã:\t\t\t+ R$20,00");
        System.out.println("Frigo Bar:\t\t\t\t+ R$20,00");
        System.out.println("Espaço de SPA:\t\t\t+ R$20,00");
        System.out.println("\nFesta Cone Simples:\t\t\t+ 40%");
        System.out.println("Festa Cone Com varanda:\t\t+ 30%\n");

        System.out.println("Pressione qualquer tecla para continuar...");
        scan.nextLine();
    }

    public static int receberInt(String mensagem)
    {
        System.out.println(mensagem);
        return Integer.parseInt(scan.nextLine());
    }

    public static String receberString(String mensagem)
    {
        System.out.println(mensagem);
        return scan.nextLine();
    }
}
