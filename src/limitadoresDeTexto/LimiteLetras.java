package limitadoresDeTexto;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public final class LimiteLetras extends JTextField {
private int maximoCaracteres=-1;// definição de -1 
// como  valor normal de um textfield sem limite de caracters
public LimiteLetras() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

public LimiteLetras(int maximo) {    
    super();
    setMaximoCaracteres(maximo);// define o tamanho máximo
//que deve ser aceito no jtextfield que foi recebido no  construtor
  
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }
  
        private void jTextFieldKeyTyped(KeyEvent evt) {
      
String caracteres="´~^]}´`.,;:/?|'+=-*à, è, ì, ò, ù,\r\n" + 
		"À,È,Ì,Ò,Ùá,é,í,ó,ú,ý\r\n" + 
		"Á,É,Í,Ó,Ú,Ýâ, ê, î, ô, û\r\n" + 
		"Â, Ê, Î, Ô, Û ã, ñ, õ\r\n" + 
		"Ã, Ñ, Õä, ë, ï, ö, ü, ÿ,\r\n" + 
		"Ä, Ë, Ï, Ö, Ü, Ÿ å, Å æ, Æ œ, Œ ç, Ç ð, Ð ø, Ø ¿<> \" ";// lista de caracters que não devem ser aceitos
if(caracteres.contains(evt.getKeyChar()+"")){// se o character que gerou o evento estiver na lista
evt.consume();//aciona esse propriedade para eliminar a ação do evento
}
if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
//if para saber se precisa verificar também o tamanho da string do campo
// maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
evt.consume();
setText(getText().substring(0,getMaximoCaracteres()));
// esta linha acima é para remover os caracters inválidos caso o usuário tenha copiado o //conteúdo de algum lugar ou seja com tamanho maior que o definido
}//fim do if do tamanho sa string do campo

        }

    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}