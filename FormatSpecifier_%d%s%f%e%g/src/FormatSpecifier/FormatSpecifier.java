package FormatSpecifier;

public class FormatSpecifier {

	public static void main(String[] args) {
		
		/*%d是用于整型*/      
        System.out.printf( "%d|%12d \n\n", 3 , 3);      
               
        /*%s是用于字符串型*/      
        System.out.printf( "%s|%s|%20s \n\n","pear", 1, "orange");

        /*%f是用于浮点形式的数字*/     
        System.out.printf( "%.2f|%.3f|%4.2f|%5.2f \n\n", 3.388, 3.388, 3.388, 3.388);   
        
        
        /*%e是用于非常大或者非常小的数字*/
        System.out.printf("%.7e \n",6.00221415*10000000*1000000*1000000*10000);
        System.out.printf("%.9e \n",6.00221415*10000000*1000000*1000000*10000);
        System.out.printf("%13.7e \n",6.00221415*10000000*1000000*1000000*10000);
        System.out.printf("%14.7e \n\n",6.00221415*10000000*1000000*1000000*10000);        
        
        /*%g也是用于非常大或者非常小的数字，但是和%e有一个区别*/
        System.out.printf("%.8g \n",6.00221415*10000000*1000000*1000000*10000);
        System.out.printf("%.10g \n",6.00221415*10000000*1000000*1000000*10000);
        System.out.printf("%13.8g \n",6.00221415*10000000*1000000*1000000*10000);
        System.out.printf("%14.8g \n\n",6.00221415*10000000*1000000*1000000*10000);           

        
        /*“%e”和“%g”唯一的区别：对于非常大的值和非常大的值，
         * 两者输出格式都是采用指数的形式，也就是带有e的形式；
         * 但是对于其他值的话，“%e”还是会带有e的形式输出，
         * 但是“%g”采用floating-point form输出。
         * */
        System.out.printf("%.8e \n",6.00221415);
        System.out.printf("%.9g \n",6.00221415);
        System.out.printf("%11.8e \n",6.00221415);
        System.out.printf("%11.9g \n\n",6.00221415);
        
        /*格式说明符中加逗号的用法，分隔开大的数字*/
        System.out.printf("%,d \n", 100000000);       
        System.out.printf("%,12.3f \n\n", 12545214512.2455422);

        /*如何输出百分号以及换行符的两种方式*/
        System.out.printf("Percentage = %% %nHello \nHi");
	}

}
