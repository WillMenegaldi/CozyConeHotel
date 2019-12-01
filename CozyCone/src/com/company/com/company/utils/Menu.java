package com.company.com.company.utils;

import com.company.com.company.enums.EStatus;
import com.company.com.company.models.Carro;
import com.company.decorators.BreakFast;
import com.company.decorators.MiniFridge;
import com.company.com.company.decorators.PartyCone;
import com.company.decorators.SpaSpace;
import com.company.com.company.enums.ETipoCone;
import com.company.interfaces.ICarro;
import com.company.interfaces.IShapeCone;

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
            System.out.println("1 - Check-in ");
            System.out.println("2 - Check-out ");
            System.out.println("3 - Listar opções e preços");
            System.out.println("0 - Sair ");

            opcao = receberInt("Digite o indice desejado:");
            Carro carro = new Carro(Carro.gerarModeloCarro(), Carro.gerarCorCarro());
            hotel.adicionarCarro(carro);

            switch (opcao)
            {
                case 1:
                    int opcaoTipoCone = receberInt("Qual tipo de cone voce deseja?\n 1 - Cone Simples\n2 - Cone Com Varanda");
                    if(opcaoTipoCone > 0 && opcaoTipoCone < 3)
                    {
                        if(opcaoTipoCone == 1)
                            System.out.println(hotel.realizarCheckIn(carro, ETipoCone.CONE_SIMPLES));
                        else
                            System.out.println(hotel.realizarCheckIn(carro, ETipoCone.CONE_COM_VARANDA));
                    }
                    break;
                case 2:
                    System.out.println(hotel.realizarCheckOut(carro));
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

    /*public IShapeCone checkIn()
    {
        Integer resp = 0;
        ConeFactory factory = new ConeFactory();
        IShapeCone cone = null;

        resp = receberInt("Qual tipo de cone deseja: 1 - sem varanda ou 2 - com varanda");
        if(resp == 1)
            cone = factory.reservarCone(ETipoCone.CONE_SIMPLES);
        else
            cone = factory.reservarCone(ETipoCone.CONE_COM_VARANDA);
        return addComponentes(cone);
    }*/

    private IShapeCone addComponentes(IShapeCone cone){
        String resp = "";
        System.out.println("Digite (s/sim) para aceitar os acrescimos ou (n/não) para regeitar");
        resp = receberString("Deseja Café da manhã:     + R$ 20,00 ?");
        if(resp.equals("sim") || resp.equals("s")){
            cone = new BreakFast(cone);
        }

        resp = receberString("Deseja Frigo Bar:         + R$ 40,00 ?");
        if(resp.equals("sim") || resp.equals("s")){
            cone = new MiniFridge(cone);
        }

        resp = receberString("Deseja Espaço de SPA:     + R$ 120,00 ?");
        if(resp.equals("sim") || resp.equals("s")){
            cone = new SpaSpace(cone);
        }

        return cone;
    }

    private IShapeCone getPartyCone(IShapeCone cone){
        String resp = "";
        resp = receberString("Digite (s/sim) caso tenha dado uma festa ou (n/não) para caso não tenha realizado!");
        if(resp.equals("sim") || resp.equals("s")){
            int resposta =  receberInt("Qual tipo de cone você está hospedado: 1 - sem varanda ou 2 - com varanda");
            if(resposta == 1)
                cone = new PartyCone(cone, ETipoCone.CONE_SIMPLES);
            else
                cone = new PartyCone(cone, ETipoCone.CONE_COM_VARANDA);
        }
        return cone;
    }

    private void listarPrecos(){
        System.out.println("Cone sem varanda:   R$ 480,00 " );
        System.out.println("Cone com varanda:    R$ 620,00 " );
        System.out.println("Café da manhã:     + R$ 20,00 " );
        System.out.println("Frigo Bar:         + R$ 20,00 " );
        System.out.println("Espaço de SPA:     + R$ 20,00 " );
        System.out.println("Festa sem varanda: + 40 %" );
        System.out.println("Festa com varanda: + 30 % " );
    }

    private static int receberInt(String mensagem) {
        System.out.println(mensagem);
        return Integer.parseInt(scan.nextLine());
    }
    private static String receberString(String mensagem) {
        System.out.println(mensagem);
        return scan.nextLine();
    }
}
