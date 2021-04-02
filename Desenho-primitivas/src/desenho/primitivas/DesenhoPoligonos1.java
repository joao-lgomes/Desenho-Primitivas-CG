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

public class DesenhoPoligonos1 implements GLEventListener{
//POLÍGONOS SÃO ÁREAS DELIMITADAS POR SEGMENTOS DE RETAS, FECHANDO UM VÉRTICE
//NORMALMENTE SÃO PREENCHIDOS POR PIXELS, MAS PODEM NÃO SER
//AS BORDAS DE UM POLÍGONO NÃO PODEM HAVER INTERSEÇÕES E OS POLÍGONOS DEVEM SER CONVEXOS
    
    
    @Override
    public void display(GLAutoDrawable drawable) {

        //CRIA UM OBJETO DO TIPO GL2 CHAMADO GL1
        GL2 gl = drawable.getGL().getGL2();

        
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        //Define a cor para as próximas instruções, em RGB. De 0 a 1 em cada parâmetro.
        gl.glColor3f(1.0f, 1.0f, 1.0f);

        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(93f, -93f);
        gl.glVertex2f(93f, 93f);
        gl.glVertex2f(-93f, 93f);
        gl.glVertex2f(-93f, -93f);
        gl.glEnd();
        
        gl.glColor3f(1.0f, 0, 0);
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2f(0f, 30f);
        gl.glVertex2f(-25f, -30f);
        gl.glVertex2f(25f, -30f);
        gl.glEnd();

        
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

        GLU glu = new GLU();
        glu.gluOrtho2D(-100f, 100f, -100f, 100f);

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
       canvas.addGLEventListener(new DesenhoPoligonos1()); 


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
