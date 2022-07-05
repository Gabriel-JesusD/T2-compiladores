package compiladores.t2;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

/**
 * Gabriel de Jesus Dantas 773412
 * BCC
 */
public class App 
{
    public static void main( String[] args )
    {
        // try(PrintWriter p = new PrintWriter(new FileWriter(args[1]))) {//saida

        

        // try(PrintWriter p = new PrintWriter(new FileWriter(args[1]))) {//saida
        try(PrintWriter p = new PrintWriter(new File(args[1]))) {//saida
            CharStream c = CharStreams.fromFileName(args[0]);//entrada
            AlgumaLexer lex = new AlgumaLexer(c);
            // alguma lex = new alguma(c); //passa o charstream lido do arquivo para o "compilador" identificar o token
            Token t = null;
            // CommonTokenStream cs = new CommonTokenStream(lex);
            CommonTokenStream cs = new CommonTokenStream(new AlgumaLexer(c));
            AlgumaParser parser = new AlgumaParser(cs);
            parser.removeErrorListeners();
            MensagemErro me = new MensagemErro(p);
            parser.addErrorListener(me);
            boolean lexical = false;
            parser.programa();
            // while((t = lex.nextToken()).getType() != Token.EOF){ //pega o proximo token enquanto não encontrar o fim do arquivo
            //     String text = '\'' + t.getText() + '\''; //converte o texto do token lido para o formato entre ''
            //     String aType = AlgumaLexer.VOCABULARY.getDisplayName(t.getType()); // Converte o tipo desse token para string
                
            //     if(aType == "Nao_Fechado"){ //Caso seja comentario nao fechado
            //         p.println("Linha " + t.getLine() + ": " + "comentario nao fechado");
            //         lexical = true;
            //         break;
            //     }
            //     else if(aType == "Literal_Nao_Fechada"){ //Caso seja literal "" nao fechado
            //     p.println("Linha " + t.getLine() + ": " + "cadeia literal nao fechada");
            //     lexical = true;
            //         break;
            //     }
            //     else if(aType == "ERR"){ //Em caso de Simbolo nao identificado
            //         p.println("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado");
            //         lexical = true;
            //         break;
            //     }
                
            // }
            // if(!lexical)
            //     parser.programa();
               
            p.println("Fim da compilacao");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
