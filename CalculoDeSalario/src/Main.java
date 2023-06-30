import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo a calculadora de salários!");

        double[] salarioBruto = new double[5];
        double[] salarioLiquido= new double[5];
        double[] inss = new double[5];
        double[] ir = new double[5];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5; i++){
            System.out.println("Insira o salário bruto do "+ (i+1)+"º funcionario");
            salarioBruto[i] = sc.nextDouble();
        }

        System.out.println("Calculando o desconto do INSS, desconto do IR e salario líquido...");

        for(int i=0; i<5; i++){
            inss[i] = calculaDescontoInss(salarioBruto[i]);
            ir[i] = calculaDescontoIR(salarioBruto[i]);
            salarioLiquido[i] = salarioBruto[i]-(inss[i]+ir[i]);
        }

        System.out.println("--------------RESULTADO--------------");
        for(int i=0; i<5; i++){
            System.out.println("Funcionário "+(i+1));
            System.out.printf("Salario bruto: R$%.2f\n",salarioBruto[i]);
            System.out.printf("Quanto pagou ao INSS: R$%.2f\n",inss[i]);
            System.out.printf("Quanto pagou de IR: R$%.2f\n",ir[i]);
            System.out.printf("Salario liquido: R$%.2f\n",salarioLiquido[i]);
            System.out.println();
        }

    }
    public static double calculaDescontoInss(double salarioBruto){
        double descontoInss = 0;

        //até 1.212,00	7,5%
        if(salarioBruto<= 1212.00){
            descontoInss=salarioBruto*0.075;
        }
        //de 1212,01 até 2.427,35	9%
        else if(salarioBruto>= 1212.01 && salarioBruto<=2427.35){
            descontoInss=salarioBruto*0.9;
        }
        //        de 2.427,36 até 3.641,03	12%
        else if(salarioBruto>=2427.36 && salarioBruto<=3641.03){
            descontoInss=salarioBruto*0.12;
        }
//        de 3.641,04 até 7.087,22	14%
        else if(salarioBruto>=3641.04 && salarioBruto<=7087.22){
            descontoInss=salarioBruto*0.14;
        }
        //acima de 7.087,22
        else if(salarioBruto>7087.22f){
            descontoInss=salarioBruto*0.14;
        }

        return descontoInss;
    }

    public static double calculaDescontoIR(double salarioBruto){
        double descontoIR=0;
//        até 1.903,98	0%
        if(salarioBruto<=1903.98){
            return descontoIR;
        }
//        de 1.903,99 até 2.826,65	7,5%
        else if(salarioBruto>= 1903.99 && salarioBruto<=2826.65){
            descontoIR=salarioBruto*0.075;
        }
//        de 2.826,66 até 3.751,05	15%
        else if(salarioBruto>= 2826.66 && salarioBruto<=3751.05){
            descontoIR=salarioBruto*0.15;
        }
//        de 3.751,06 até 4.664,68	22,50%
        else if(salarioBruto>=3751.06 && salarioBruto<=4664.68){
            descontoIR=salarioBruto*0.225;
        }
//        Acima de 4.664,68	27,50%
        else if(salarioBruto>4664.68){
            descontoIR=salarioBruto*0.275;
        }
        return descontoIR;
    }
}