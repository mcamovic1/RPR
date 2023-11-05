package org.example;
public class FiksniBroj extends TelefonskiBroj {
        private Grad grad;
        private String broj;
        public Grad getGrad() {
        return grad;
       }


        public String getBroj() {
        return broj;
       }


       public FiksniBroj (Grad grad, String broj){
           this.broj=broj;
           this.grad=grad;
       }
       @Override
       public String Ispisi(){
           return 0+ hashCode() +broj;
       }
       @Override
      public int hashCode(){
           if (grad.ordinal()==10) {
               return 49;
           }
           return 30+ grad.ordinal();
       }
}
