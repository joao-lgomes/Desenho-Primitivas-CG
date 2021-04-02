package desenho.primitivas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class DesenhoPontos1 implements GLEventListener{

//OS PONTOS SÃO REPRESENTADOS POR UM CONJUNTO DE PONTOS FLUTUANTES CHAMADOS DE VÉRTICES(VERTEX).
//INFORMA-SE O X, Y e Z PARA CONSTRUIR ALGUM PONTO
    
    
    @Override
    public void display(GLAutoDrawable drawable) {

        //CRIA UM OBJETO DO TIPO GL2 CHAMADO GL1
        GL2 gl = drawable.getGL().getGL2();

        
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        //Define a cor para as próximas instruções, em RGB. De 0 a 1 em cada parâmetro.
        gl.glColor3f(1f, 0, 0);
        
        //DEFINE A VARIÁVEL QUE DETERMIARÁ O LAÇO FOR
        float i = -1.0f;
        //DEFINE O TAMANHO QUE CADA PONTO INICIARÁ
        float tamanho = 1f;
        
        //CRIA O LAÇO PARA FAZER A LINHA DE PONTOS
        for(i=i; i<=1.0f; i+=0.02f){
            //DEFINE QUE A CADA LAÇO A VARIÁVEL TAMANHO AUMENTA EM 0.1
            tamanho+=0.1;
            //DETERMINA QUE OS TAMANHOS DOS PONTOS SERÃO DEFINIDOS PELA VARIÁVEL TAMANHO
            gl.glPointSize(tamanho);
            //DEFINE QUE INICIARÁ SEU COMANDO, COM O PARÂMETRO DE PONTOS
            gl.glBegin(GL.GL_POINTS);
            //DEFINE QUE CRIARÁ UM PONTO NO VERTICE X DA VARIÁVEL I, E NO VERTICE Y NO PONTO 0
            gl.glVertex2f(i, 0f);
            //TERMINA O COMANDO
            gl.glEnd();
        }
        
        
        //Executa na tela todas as instruções guardadas na memória até aqui
        gl.glFlush();

    }

 
 
 
 
    @Override
    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }

 
 
 
    @Override
    public void init(GLAutoDrawable drawable) {
        
        //Cria um evento do tipo GL2 chamado GL
        GL2 gl = drawable.getGL().getGL2();

        //Define uma nova cor para utilizar nas próximas instruções, em RGBA
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glMatrixMode(GL2.GL_MATRIX_MODE);
        gl.glLoadIdentity();

        //GLU glu = new GLU();
        //glu.gluOrtho2D(-1.0f, 1.0f, -1.0f, 1.0f);

    }

 
 
 
    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // TODO Auto-generated method stub

    }
 
 
 
 
    public static void main(String[] args) {

       //implementa a interface GL que reflete todos os tipos de dados comuns, texturas e funcionalidades do framebuffer
       //GL2 indica qual versão da OPENGL está sendo utilizada
       GLProfile profile = GLProfile.get(GLProfile.GL2);

       //especifica diversos recursos da OPENGL
       GLCapabilities caps = new GLCapabilities(profile);

       //CRIA UM PAINEL E ADICIONA UM OUVINTE GLEventListenner
       GLCanvas canvas = new GLCanvas(caps); 
       canvas.addGLEventListener(new DesenhoPontos1()); 


        // CRIA UMA JANELA E ADICIONA O PAINEL
        
        //criando um novo JFrame e colocando seu nome como "Primeiro Programa OPENGL"
        JFrame frame = new JFrame("Primeiro Programa OPENGL");
        
        //adiciona o canvas ao frame
        frame.add(canvas);
        //configura o tamanho do JFrame
        frame.setSize(400, 300);
        //Seleciona que o JFrame será fechado quando sua janela for fechada
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //define suas visualização como verdadeira
        frame.setVisible(true);

    }
}
