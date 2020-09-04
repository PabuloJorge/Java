package Arvore;

public class Teste_Arvore {
	
	public static NoTree insert (NoTree p, int d){
        if (p == null){
            p = new NoTree(d, d*2);
            /*p = new NoTree();
            p.info = d;
            p.L = null;
            p.R = null;
            */
            return p;
        } 
        else {
            if (d > p.info) {
                p.R = insert(p.R, d);
            }else {
                p.L = insert(p.L, d);
            }
            return p;
        }
    }

 

    public static void Ler_LDR (NoTree p){
        if (p != null){
        	Ler_LDR(p.L);
            System.out.print(p.info+ " ");
            Ler_LDR(p.R);
        }
    }

 

    public static void Ler_DLR (NoTree p){
        if (p != null){
            System.out.print(p.info+ " ");
            Ler_DLR(p.L);
            Ler_DLR(p.R);
        }
    }

 

    public static void Ler_LRD (NoTree p){
        if (p != null){
            Ler_LRD(p.L);
            Ler_LRD(p.R);
            System.out.print(p.info+ " ");
        }
    }
    

 

    public static void printNo (NoTree p, int chave){
        if (p != null){
            printNo(p.L, chave);
            printNo(p.R, chave);
            if (p.info==chave) System.out.println(p.info+ " ");
        }
    }
    
    public static NoTree search(NoTree p, int d) {
        if (p == null) {
            return p;
        } else {
            if (d == p.info) {
                return p;
            } else {
                if (d > p.info) {
                    return search(p.R, d);
                } else {
                    return search(p.L, d);
                }
            }
        }
    }

 

    public static NoTree search2(NoTree p, int key){
        NoTree aux = p;
        while(aux != null){
            if(aux.info == key){
                return aux;
            }
            else if(aux.info > key){
                aux = aux.L;
            }
            else{
                aux = aux.R;
            }
        }
        return aux;
    }

 

    public static void main(String[] args) {

 

        int vet [] = { 9, 5, 14, 3, 7, 12, 17, 2, 4, 6, 8, 13, 16, 18 };
        NoTree a, resp;
        
        a = null;
    
        for (int i = 0; i < vet.length; i++){
            a = insert(a, vet[i]);
        }
        

 

        System.out.print("Árvore (DLR): [ ");
        Ler_DLR(a);
        System.out.println(" ]");
        
        System.out.print("Árvore (LDR): [ ");
        Ler_LDR(a);
        System.out.println(" ]");
        
        System.out.print("Árvore (LRD): [ ");
        Ler_LRD(a);
        System.out.println(" ]");
        
        System.out.println("--- printNo ---");
        printNo(a, 16);

 

        int b = 17;
        System.out.println("--- search ---");
        resp = search(a, b);
        if (resp!= null) System.out.println( "Chave (info): "+ resp.info + "\ndobro = " + resp.dobro);
        else System.out.println("Não encontrou!");
        System.out.println("--- search2 ---");
        resp = search2(a, b);
        if (resp!= null) System.out.println( "Chave (info): "+ resp.info + "\ndobro = " + resp.dobro);
        else System.out.println("Não encontrou!");

 

    }
}
