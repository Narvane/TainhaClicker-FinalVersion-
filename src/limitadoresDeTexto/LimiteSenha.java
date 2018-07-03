package limitadoresDeTexto;

import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public final class LimiteSenha extends JPasswordField {
private int maximoCaracteres=-1;// defini��o de -1 
// como  valor normal de um textfield sem limite de caracters
public LimiteSenha() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
       jPasswordFieldKeyTyped(evt);}});
    }

public LimiteSenha(int maximo) {    
    super();
    setMaximoCaracteres(maximo);// define o tamanho m�ximo
//que deve ser aceito no jtextfield que foi recebido no  construtor
  
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jPasswordFieldKeyTyped(evt);}});
    }
  
        @SuppressWarnings("deprecation")
		private void jPasswordFieldKeyTyped(KeyEvent evt) {
      
String caracteres="�~^]}�`.,;:/?|'+=-*�, �, �, �, �,\r\n" + 
		"�,�,�,�,��,�,�,�,�,�\r\n" + 
		"�,�,�,�,�,��, �, �, �, �\r\n" + 
		"�, �, �, �, � �, �, �\r\n" + 
		"�, �, ��, �, �, �, �, �,\r\n" + 
		"�, �, �, �, �, � �, � �, � �, � �, � �, � �, � � <> \"";// lista de caracters que n�o devem ser aceitos
if(caracteres.contains(evt.getKeyChar()+"")){// se o character que gerou o evento estiver na lista
evt.consume();//aciona esse propriedade para eliminar a a��o do evento
}
if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
//if para saber se precisa verificar tamb�m o tamanho da string do campo
// maior ou igual ao tamanho m�ximo, cancela e nao deixa inserir mais
evt.consume();
setText(getText().substring(0,getMaximoCaracteres()));
// esta linha acima � para remover os caracters inv�lidos caso o usu�rio tenha copiado o //conte�do de algum lugar ou seja com tamanho maior que o definido
}//fim do if do tamanho sa string do campo

        }

    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}