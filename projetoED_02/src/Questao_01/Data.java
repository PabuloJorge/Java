package Questao_01;

public class Data {
	
	private int dia;
    private int mes;
    private int ano;
    private int dias_mes;

    public Data(int dia, int mes, int ano) {
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);

    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia > 0 && dia <= validarDias(getMes())) {
            this.dia = dia;
        } else {
            System.out.println("Dia inválido!");
        }
    }

    public int getMes() {
        return mes;
    }

    void setMes(int mes) {
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        } else {
            System.out.println("Mês inválido!");
        }
    }

    public int getAno() {

        return ano;

    }

    public void setAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido!");
        }
    }
//VERIFICA QUANTOS DIAS O MÊS TEM

    public int validarDias(int mes) {
        if (mes == 01 || mes == 03 || mes == 05 || mes == 07 || mes == 8 || mes == 10 || mes == 12) {
            dias_mes = 31;
        } else if (mes == 04 || mes == 06 || mes == 9 || mes == 11) {
            dias_mes = 30;

            // verificar se o ano é bissexto
        } else if (ano % 400 == 0) {
            dias_mes = 29;
        } else if ((ano % 4 == 0) && (ano % 100 != 0)) {
            dias_mes = 29;
        } else {
            dias_mes = 28;
        }

        return dias_mes;

    }
//VERIFICA QUANTOS DIAS O MÊS TEM COM PARAMETRO DIFERENTE

    public int validarDias2(int mes, int ano) {
        if (mes == 01 || mes == 03 || mes == 05 || mes == 07 || mes == 8 || mes == 10 || mes == 12) {
            dias_mes = 31;
        } else if (mes == 04 || mes == 06 || mes == 9 || mes == 11) {
            dias_mes = 30;

            // verificar se o ano é bissexto
        } else if (ano % 400 == 0) {
            dias_mes = 29;
        } else if ((ano % 4 == 0) && (ano % 100 != 0)) {
            dias_mes = 29;
        } else {
            dias_mes = 28;
        }

        return dias_mes;

    }
// EXIBE NO FORMATO DE DATA

    public String toString() {
        String s = "";
        if (dia < 10) {
            s = "0" + dia + "/";
        } else {
            s = dia + "/";
        }

        if (mes < 10) {
            s += "0" + mes + "/";
        } else {
            s += mes + "/";
        }

        if (ano < 10) {
            s += "000" + ano;
        } else if (ano < 100) {
            s += "00" + ano;
        } else if (ano < 1000) {
            s += "0" + ano;
        } else {
            s += ano;
        }

        return s;
    }
// CALCULA INTERVALO

    public int diasEntreDatas(int dia, int mes, int ano) {
        int intervalo = 0;

        /* CALCULA DIAS DOS ANOS >>ENTRE<< AS DATAS
         EX: 
         PRIMEIRA DATA >> 01/01/2020
         SEGUNDA DATA >> 01/01/2025
         INT ANO = 0;
         2021 > INTERVALO += 365;
         2022 > INTERVALO += 365;
         2023 > INTERVALO += 365;
         2024 > INTERVALO += 366; */
        if (this.ano > ano) {

            for (int i = ano + 1; i < this.ano; i++) {
                // se o ano for maior que 400
                if (i % 400 == 0) {
                    intervalo += 366;
                } else if ((i % 4 == 0) && (i % 100 != 0)) {
                    intervalo += 366;
                } else {
                    intervalo += 365;
                }

            }
        } else {
            for (int i = this.ano + 1; i < ano; i++) {
                // se o ano for maior que 400
                if (i % 400 == 0) {
                    intervalo += 366;
                } else if ((i % 4 == 0) && (i % 100 != 0)) {
                    intervalo += 366;
                } else {
                    intervalo += 365;
                }

            }

            /* CALCULA INTERVALO DE DIAS DO MES DA DATA FINAL E INICIAL
             EX:
             PRIMEIRA DATA >> 01/01/2020 >> DIAS QUE FALTAM PARA CHEGAR ATÉ O FIM DO MÊS
             SEGUNDA DATA >> 10/01/2021 >> DIAS QUE SE PASSARAM DO MÊS ATUAL 
             */
        }
        if (this.mes == mes && this.ano == ano) {
            if (this.dia < dia) {
                intervalo += dia - this.dia;

            } else if (this.dia > dia) {
                intervalo += this.dia - dia;
            }
        } else if (this.mes < mes) {
            intervalo += validarDias(this.mes) - this.dia;
            intervalo += dia;
        } else {
            intervalo += validarDias2(mes, ano) - dia;
            intervalo += this.dia;
        }

        /* CALCULA INTERVALO DE DIAS REFERENTE AOS MESES DAS DATAS
         EX:
         PRIMEIRA DATA >> 01/01/2020 >> DIAS QUE FALTAM PARA CHEGAR DO MÊS SEGUINTE ATÉ O FIM DO ANO
         SEGUNDA DATA >> 10/01/2021 >> DIAS QUE SE PASSARAM DO INICIO DO ANO ATUAL ATÉ O FIM DO MÊS ANTERIOR 
         */
        if (this.ano != ano) {
            if (this.ano < ano) {
                for (int i = this.mes + 1; i <= 12; i++) {
                    intervalo += validarDias(i);
                }
                for (int i = 1; i < mes; i++) {
                    intervalo += validarDias2(i, ano);
                }
            } else {
                for (int i = mes + 1; i <= 12; i++) {
                    intervalo += validarDias(i);
                }
                for (int i = 1; i < this.mes; i++) {
                    intervalo += validarDias(i);
                }
            }
        } else {
            if (this.mes < mes) {
                for (int i = this.mes + 1; i < mes; i++) {
                    intervalo += validarDias(i);
                }

            } else {
                for (int i = mes + 1; i < this.mes; i++) {
                    intervalo += validarDias(i);
                }

            }
        }
        // DEIXAR O VALOR NEGATIVO SE A DATA FINAL FOR MENOR QUE A INICIAL
        if (this.ano != ano) {
            if (this.ano > ano) {
                intervalo = intervalo - (intervalo * 2);
            }
        } else if (this.mes > mes) {
            intervalo = intervalo - (intervalo * 2);
        } else if (this.mes == mes) {
            if (this.dia > dia) {
                intervalo = intervalo - (intervalo * 2);
            }
        }
        return intervalo;
    }

}
