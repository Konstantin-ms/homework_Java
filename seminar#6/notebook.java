package seminar#6;

public class notebook {
    int art;
    String firm;
    int diag;
    int ram;
    int hd;
    int ops;
    int color;
    int price;
    String[] ops_system = {"Не важно","Windows","Linux","MacOs"};
    String[] sizes_diag = {"Не важно","14\"","15,6\"","17\"","20\"","22\"","24\""};
    String[] colors = {"Не важно","Black","White","Gray","Silver","Red","Blue","Pink"};

    
    notebook(int inp_art, String inp_firm, int inp_diag,int inp_ram, 
    int inp_hd, int inp_ops, int inp_col, int inp_prc){
        art = inp_art;
        firm = inp_firm;
        diag= inp_diag;
        ram = inp_ram;
        hd = inp_hd;
        ops = inp_ops;
        color = inp_col;
        price = inp_prc;}

    @Override

    public String toString() {        
        return ("\nАртикул : "+art+" /Производитель : "+firm
        +" /Диагональ : "+sizes_diag[diag]+" /ОЗУ(RAM) : "+ram+" /ПЗУ(HD) : "
        +hd+"\n /Операционная система : "+ops_system[ops]+" /Цвет : "
        +colors[color]+" /Цена : "+price);} 
    
}

