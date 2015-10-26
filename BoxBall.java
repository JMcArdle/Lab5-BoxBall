import java.awt.*;
import java.awt.geom.*;

/**
 * The BoxBall class creates balls within a canvas, disregarding gravity and any of its effects. 
 * These balls should be able to bounce off any wall continuously and rebound to other walls. 
 * 
 * @author Joshua McArdle 
 * @version 1.0.0
 * @since 2015-10-19
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int leftWallPosition;
    private final int rightWallPosition;
    private final int ceilingPosition;
    private Canvas canvas;
    private int xSpeed = 3;
    private int ySpeed = 4;                // initial downward speed

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param lWallPos   the position of the left wall
     * @param rWallPos   the position of the right wall
     * @param ceilPos    the position of the ceiling 
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int lWallPos, int rWallPos, int ceilPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        leftWallPosition = lWallPos;
        rightWallPosition = rWallPos;
        ceilingPosition = ceilPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /** 
     * Move this ball according to its position and speed and redraw
     **/
     public void move()
     {
         //remove from canvas at current position
         erase();
         
         //calculate new position
         xPosition += xSpeed;
         yPosition += ySpeed;
         
         //check to see if it hit any of the walls
         if(yPosition >= (groundPosition - diameter)) {
             yPosition = (int)(groundPosition - diameter);
             ySpeed = -ySpeed;
             
            }
            else if (yPosition <= (ceilingPosition + diameter)) {
                yPosition = (int)(ceilingPosition - diameter);
                ySpeed = -ySpeed;
            }
            if (xPosition <= (leftWallPosition + diameter)) {
                xPosition = (int)(leftWallPosition - diameter);
                xSpeed = -xSpeed;
            }
            else if (xPosition >= (rightWallPosition - diameter)) {
                 xPosition = (int)(rightWallPosition - diameter);
                 xSpeed = -xSpeed;
                }
                
                // draw again at a new position
                draw();
            }
            
             
}