package jogo;

/*
 * Laser Pinball
 * Copyright (C) 2012 meatfighter.com
 *
 * This file is part of Laser Pinball.
 *
 * Laser Pinball is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Laser Pinball is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.applet.Applet;

public class a extends Applet implements Runnable {

  // keys
  private boolean[] a = new boolean[65535];
  
  public a() {
    new Thread(this).start();
  }

  @Override
  public void run() {
    
    final float GRAVITY = 0.15f;  
    final float DAMPENING = 1.5f;
    final float BALL_RADIUS = 19.5f;
    final int MAX_VELOCITY = 32;
    final int BUMPER_VELOCITY = 16;
    final int FLIPPER_DELAY = 8;
    final int FLIPPER_VELOCITY = 24;
    final int ITEMS = 12;
    final int EXTRA_BALL_BONUS = 15000;
    
    final float BALL_RADIUS2 = BALL_RADIUS * BALL_RADIUS;
    final float MAX_VELOCITY2 = MAX_VELOCITY * MAX_VELOCITY;
   
    final int VK_ENTER = 10;
    final int VK_SPACE = 32;
    final int VK_LEFT_0 = 97;
    final int VK_LEFT_1 = 113;
    final int VK_RIGHT_0 = 39;
    final int VK_RIGHT_1 = 108;
        
    final int BALL_LAYER = 0;
    final int BALL_X = 1;
    final int BALL_Y = 2;
    final int BALL_VX = 3;
    final int BALL_VY = 4; 
    final int BALL_TIME = 5;
    final int BALL_STUCK = 6;
    
    final int IMAGE_BUFFER = 0;
    final int IMAGE_LAYER_0 = 1;
    final int IMAGE_LAYER_1 = 2;
    final int IMAGE_BALL = 3;
    final int IMAGE_PLUNGER = 4;
    final int IMAGE_GATE = 5;
    final int IMAGE_BUMPER = 6;
    final int IMAGE_SLINGSHOT = 7;
    final int IMAGE_FLIPPER = 8;    

    int i;
    int j;
    int k;
    int p;
    int q;
    int u;
    int x;
    int y;
    int z;
    int x1;
    int y1;
    int x2;
    int y2;
    int cameraY = 0;
    int plungerX = 0;
    int leftBumper = 0;
    int rightBumper = 0;
    int leftSlingshot = 0;
    int rightSlingshot = 0;
    int leftFlipperCounter = 0;
    int rightFlipperCounter = 0;
    int score = 0;
    int lastScore = 0;
    int extraBalls = 0;
    int multiplier = 0;
    int ballCount = 0;
    float fx;
    float fy;
    float vx;
    float vy;
    float mag;
    float t;
    float leftFlipperAngle = 0; 
    float rightFlipperAngle = 0;     
    float[] ball;
    float[] ball2;
    boolean lowerLeftGateEnabled = false;
    boolean railGateEnabled = false;
    boolean cameraOnTarget = false;
    boolean hit = false;
    boolean gameOver = true;
    
    int[][] itemsTable = null;
    
    // layer 0 lines, layer 0 arcs, layer 1 lines, layer 1 arcs
    // items table, image size table
    final String S = "\ubc1b\ubcff\ua829\ua81a\ua81a\ub127\ub127\ub1ff\u9554"
        + "\u8e66\u8e66\u9168\u9168\ua153\uaf57\u9290\u9290\u9593\u9e9b\ub1ae"
        + "\u700f\u760f\u760f\u7615\u7615\u7015\u7015\u700f\u830f\u890f\u890f"
        + "\u8916\u8916\u8316\u8316\u830f\u9711\u9d11\u9d11\u9d1c\u9d1c\u971c"
        + "\u971c\u9711\ub1e0\u9aee\u9aee\u9aff\u25ff\u25f1\u25f1\u19ea\u19ea"
        + "\u19f5\u19f5\u0df5\u0df5\u0dab\u1ca0\u1c84\u1c84\u013e\u013e\u010c"
        + "\u0f0c\u0f3e\u0f3e\u2162\u2162\u2560\u2560\u1d4b\u440a\u7401\u7401"
        + "\ua301\u19d4\u19dc\u19dc\u31e9\u31e9\u34e7\u34e7\u19d4\ua4d4\ua4dc"
        + "\ua4dc\u8ce9\u8ce9\u89e7\u89e7\ua4d4\u29b2\u37d6\u37d6\u32d8\u32d8"
        + "\u24cc\u24cc\u24b4\u24b4\u29b2\u93b2\u85d6\u85d6\u8ad8\u8ad8\u98cc"
        + "\u98cc\u98b4\u98b4\u93b2\u2c4a\u3748\u3748\u302d\u3d28\u5558\u5558"
        + "\u5858\u5858\u5f40\u5f3f\u7a44\u6316\u6319\u19b3\u19d4\ua4b3\ua4d4"
        + "\u6f43\u6f59\u6f59\u705a\u7c61\u7e62\u7e62\u8459\ub1db\ubcdb\u963b"
        + "\u19be\u0064\u9c94\u07cd\u00af\u1bae\u0e3d\u003d\u080d\u0700\u0080"
        + "\u4b3b\u3146\u004b\ua21b\u1a00\u003f\u543d\u2a31\u0060\u672d\u1448"
        + "\u006a\u775c\u07dd\u009a\u7852\u0ee4\u005a\u732b\u0c00\u00ff\u963b"
        + "\u0c00\u00ff\u9c59\uac45\ua866\ub252\uba52\uba97\uba97\u98b8\u98b8"
        + "\u98ce\uc752\uc79c\uc79c\ua4bf\ua4bf\ua4ce\u5858\u5f40\u5f40\u601f"
        + "\u6f1f\u6f59\u8f1f\u8f60\u8f60\ua475\ua475\u9f7f\u9c1f\u9c5b\u9c5b"
        + "\uaa6a\uaf78\uaa85\u1317\u136e\u136e\u0180\u0180\u019a\u0f9a\u0f86"
        + "\u0f86\u1382\u1382\u13b7\u13b7\u18bc\u18bc\u18cf\u26cf\u26b8\u26b8"
        + "\u21b3\u21b3\u2115\u2915\u302d\u302d\u3748\u3713\u3d28\u3d28\u4b44"
        + "\u9ece\u0680\u0080\ub653\u0400\u007d\ub653\u1100\\\u7e1f\u1e00\u007f"
        + "\u7f1f\u1000\u007f\ua483\u0666\u008e\ua075\u0ff8\u002c\u089a\u0780"
        + "\u0082\u1fce\u0780\u007a\u2516\u1208\u007a\u2516\u0408\u007a\u01a6"
        + "\u0048\u01f3\u0056\u0242\u0048\u028b\u0056\u0021\u0056\u0159\u0034"
        + "\u00a1\u035f\u025a\u026f\u0256\u035f\u00a7\u0221\u00a7\u0261\u00a7"
        + "\u02a1\uc896\uc8fa\uc8fa\u2a2a\u1030\u1710\u3939\u3939\u341b"; 
    
    final BufferedImage[] images = new BufferedImage[9];
        
    final float[][] balls = new float[3][8];
    final float[][][][][] layers = new float[2][48][32][67][2];
    final int[][][] boxSizes = new int[2][48][32];
    float[][] box;
    final Graphics2D[] imageGraphics = new Graphics2D[9];
    Graphics2D g = null;
    Graphics2D g2 = null;
    
    // create images
    for(i = 0; i < 9; i++) {
      (imageGraphics[i] = (Graphics2D)(images[i] = new BufferedImage(
          (S.charAt(i + 297) >> 8) << 2, 
              (S.charAt(i + 297) & 0xFF) << 2, i < 2 
                  ? BufferedImage.TYPE_INT_RGB 
                      : BufferedImage.TYPE_INT_ARGB_PRE)).getGraphics())
          .setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
              RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    // decompress lines
    for(q = 0; q < 2; q++) {
      g = imageGraphics[IMAGE_LAYER_0 + q];
            
      for(j = 63; j >= 0; j--) { // glow loop
        
        // draw lines
        for(i = 0; i < (q == 0 ? 70 : 32); i++) {
          p = q == 0 ? 0 : 176;
          k = (i << 1) + p;
          x1 = (S.charAt(k) >> 8) << 2;
          y1 = (S.charAt(k) & 0xFF) << 2;
          x2 = (S.charAt(k + 1) >> 8) << 2;
          y2 = (S.charAt(k + 1) & 0xFF) << 2; 
          g.setColor(j == 0 ? q == 0 ? Color.WHITE 
                  : new Color(255, 255, 128) : 
              q == 0 ? new Color(0, 0, (63 - j) << 2) 
                  : new Color(255, 255, 0, (63 - j) >> 3));
          g.setStroke(new BasicStroke(j + 5, BasicStroke.CAP_ROUND, 
              BasicStroke.JOIN_ROUND));
          g.drawLine(x1, y1, x2, y2);
          if (j == 0) {
            vx = x2 - x1;
            vy = y2 - y1;
            mag = (float)Math.sqrt(vx * vx + vy * vy);
            for(u = 0; u <= mag; u++) {
              fx = x1 + vx * u / mag;
              fy = y1 + vy * u / mag;            
              ball = layers[q][((int)fy) >> 5][((int)fx) >> 5]
                  [boxSizes[q][((int)fy) >> 5][((int)fx) >> 5]++];
              ball[0] = fx;
              ball[1] = fy;
            }
          }
        }
        
        // draw arcs
        for(i = 0; i < (q == 0 ? 12 : 11); i++) {
          p = q == 0 ? 140 : 240;
          k = i * 3 + p;
          x = (S.charAt(k) >> 8) << 2;
          y = (S.charAt(k) & 0xFF) << 2;
          z = (S.charAt(k + 1) >> 8) << 2;

          float startAngle = (S.charAt(k + 1) & 0xFF) * 0.02464f;
          float endAngle = startAngle + S.charAt(k + 2) * 0.02464f;

          x1 = -1;
          y1 = 0;
          for(float angle = startAngle; angle <= endAngle; angle += 0.125f) {
            x2 = (int)(x + z * (float)Math.cos(angle));
            y2 = (int)(y - z * (float)Math.sin(angle));
            if (x1 >= 0) {
              g.setColor(j == 0 ? q == 0 ? Color.WHITE 
                  : new Color(255, 255, 128) : 
              q == 0 ? new Color(0, 0, (63 - j) << 2) 
                  : new Color(255, 255, 0, (63 - j) >> 5));
              g.setStroke(new BasicStroke(j + 5, BasicStroke.CAP_ROUND, 
                  BasicStroke.JOIN_ROUND));
              g.drawLine(x1, y1, x2, y2);
              if (j == 0) {
                vx = x2 - x1;
                vy = y2 - y1;
                mag = (float)Math.sqrt(vx * vx + vy * vy);
                for(u = 0; u <= mag; u++) {
                  fx = x1 + vx * u / mag;
                  fy = y1 + vy * u / mag;            
                  ball = layers[q][((int)fy) >> 5][((int)fx) >> 5]
                      [boxSizes[q][((int)fy) >> 5][((int)fx) >> 5]++];
                  ball[0] = fx;
                  ball[1] = fy;
                }
              }
            }
            x1 = x2;
            y1 = y2;
          }
        }      
      }
    }
         
    // create ball sprite
    g = imageGraphics[IMAGE_BALL];
    for(j = 63; j >= 0; j--) {
      g.setColor(j == 0 ? Color.GREEN : new Color(255, 0, 0, (63 - j) >> 3));
      g.fillOval(65 - j, 65 - j, 39 + (j << 1), 39 + (j << 1));
    }
    
    // create bumper sprite
    g = imageGraphics[IMAGE_BUMPER];
    for(j = 63; j >= 0; j--) {
      g.setColor(j == 0 ? Color.WHITE 
          : new Color(255, 255, 255, (63 - j) >> 3));
      g.fillOval(63 - j, 63 - j, 100 + (j << 1), 100 + (j << 1));
    }
    
    // create slingshot sprite
    g = imageGraphics[IMAGE_SLINGSHOT];
    for(j = 63; j >= 0; j--) {
      g.setColor(new Color(255, 255, 255, (63 - j) >> 3));
      g.fillOval(63 - j, 63 - j, 100 + (j << 1), 100 + (j << 1));
    }   
    
    // create gate sprite
    g = imageGraphics[IMAGE_GATE];
    for(j = 63; j >= 0; j--) {
      g.setColor(j == 0 ? Color.WHITE : new Color(0, 128, 255, (63 - j) >> 3));
      g.setStroke(new BasicStroke(j + 5, BasicStroke.CAP_ROUND, 
              BasicStroke.JOIN_ROUND));
      g.drawLine(32, 32, 64, 32);
    }    
       
    // create plunger sprite
    g = imageGraphics[IMAGE_PLUNGER];
    for(j = 63; j >= 0; j--) {
      g.setColor(j == 0 ? Color.WHITE : new Color(255, 0, 255, (63 - j) >> 3));
      g.setStroke(new BasicStroke(j + 5, BasicStroke.CAP_ROUND, 
              BasicStroke.JOIN_ROUND));
      g.drawLine(32, 32, 32, 160);
    }    
        
    // create flipper sprites
    g = imageGraphics[IMAGE_FLIPPER];
    for(j = 63; j >= 0; j--) {
      g.setColor(j == 0 ? Color.WHITE 
          : new Color((63 - j) << 2, 0, (63 - j) << 2));
      for(i = 0; i < 106; i++) {        
        g.fillOval(32 + i - (j >> 1), 32 - (j >> 1), 
            22 + (i * 3 >> 4) + j, 22 + (i * 3 >> 4) + j);
      }
    }
    for(i = 0; i < 108; i++) {
      for(j = 0; j < 208; j++) {
        x = (k = images[IMAGE_FLIPPER].getRGB(j, i)) & 0xFF;         
        images[IMAGE_FLIPPER].setRGB(j, i, 
            ((k >> 8) & 0xFF) == 0 ? (x << 24) | (x << 16) | x : -1);             
      }
    }
    
    // draw top barriers and slot kicker
    g = imageGraphics[IMAGE_LAYER_0];
    g.drawImage(images[IMAGE_PLUNGER], 364, -60, null);
    g.drawImage(images[IMAGE_PLUNGER], 640, -60, null);
    g.drawImage(images[IMAGE_PLUNGER], 45, 946, null);
       
    g = imageGraphics[IMAGE_BUFFER];
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));    
    AffineTransform transform = new AffineTransform();
    
    a[VK_ENTER] = true;
    long nextFrameStartTime = System.nanoTime();
    while(true) {

      do {
        nextFrameStartTime += 16666667;

        // -- update starts ----------------------------------------------------
        
        if (gameOver && a[VK_ENTER]) {
          
          // start/reset game          
          a[VK_ENTER] = false;
          gameOver = false; 
          lowerLeftGateEnabled = false;
          hit = false;                    
          cameraY = 0;
          score = 0;
          lastScore = 0;          
          railGateEnabled = true;
          multiplier = 1;
          ballCount = 1;
          ball = balls[0] = new float[8];          
          ball[BALL_X] = 730;
          ball[BALL_Y] = 854;           
          
          // decompress items table
          itemsTable = new int[12][extraBalls = 999];
          for(i = 0; i < ITEMS; i++) {       
            itemsTable[i][0] = S.charAt((i << 1) + 273);
            itemsTable[i][1] = S.charAt((i << 1) + 274);
            itemsTable[i][3] = i > 8 ? 2 : i > 3 ? 1 : 0;
          }
        } 
        
        // update plunger
        int plungerStrike = 0;
        if (!gameOver && a[VK_SPACE]) {
          if (plungerX < 64) {
            plungerX++;
          }
        } else if (plungerX > 0) {
          plungerStrike = plungerX;
          plungerX = 0;          
        }
        
        // update left flipper
        if (!gameOver && (a[VK_LEFT_0] || a[VK_LEFT_1])) {
          leftFlipperCounter++;
          if (leftFlipperAngle > -0.44f) {
            leftFlipperAngle -= 0.3f;
          }
        } else {
          leftFlipperCounter = 0;
          if (leftFlipperAngle < 0.44f) {
            leftFlipperAngle += 0.3f;
          } else {
            leftFlipperAngle = 0.44f;
          }
        }
        
        // update right flipper
        if (!gameOver && (a[VK_RIGHT_0] || a[VK_RIGHT_1])) {
          rightFlipperCounter++;
          if (rightFlipperAngle > -0.44f) {
            rightFlipperAngle -= 0.3f;
          }
        } else {
          rightFlipperCounter = 0;
          if (rightFlipperAngle < 0.44f) {
            rightFlipperAngle += 0.3f;
          } else {
            rightFlipperAngle = 0.44f;
          }
        }

        // update bumpers and slingshots
        if (leftBumper > 0) {
          leftBumper--;
        }
        if (rightBumper > 0) {
          rightBumper--;
        }
        if (leftSlingshot > 0) {
          leftSlingshot--;
        }
        if (rightSlingshot > 0) {
          rightSlingshot--;
        }
               
        // update balls
        int maxBallY = 0;
        int cameraVy = 0;
        for(i = ballCount - 1; i >= 0; i--) { 
          ball = balls[i];
          
          if (ball[BALL_Y] > 1170) {
            
            // ball lost
            for(j = i; j < 2; j++) {
              balls[j] = balls[j + 1];
            }
            ballCount--;
            
            if (hit) {     
              if (ballCount == 0 && !(gameOver = extraBalls == 0)) {
                // position next ball over plunger
                ball = balls[ballCount++] = new float[8];
                ball[BALL_X] = 730;                
                ball[BALL_Y] = 854;
                maxBallY = 854;
                extraBalls++;
                hit = false;
                lowerLeftGateEnabled = false;
                multiplier = 1;
              }
            } else {
              // ball lost, but no flipper hits; return ball
              ball = balls[ballCount++] = new float[8];
              ball[BALL_X] = 475;
              ball[BALL_Y] = 369;
              ball[BALL_VX] = ball[BALL_VY] = 0;
              ball[BALL_STUCK] = 80;
            }

            continue;
          }

          // ball cannot travel faster than max speed
          mag = ball[BALL_VX] * ball[BALL_VX] 
              + ball[BALL_VY] * ball[BALL_VY];
          if (mag > MAX_VELOCITY2) {
            mag = MAX_VELOCITY / (float)Math.sqrt(mag);
            ball[BALL_VX] *= mag;
            ball[BALL_VY] *= mag;
          }
          
          // find max ball Y for camera tracking
          if (ball[BALL_Y] > maxBallY) {
            maxBallY = (int)ball[BALL_Y];
            
            // camera speed depends on if ball is stuck or moving
            cameraVy = ball[BALL_STUCK] < 80 && ball[BALL_STUCK] >= 48 ? 4 : 24;
          }          
          
          // ball clock advances 1 time unit
          ball[BALL_TIME]++;
          
          do {
            
            // ball takes steps no larger than 1 unit
            t = ball[BALL_TIME];      
            vx = t * ball[BALL_VX];
            vy = t * ball[BALL_VY];
            mag = vx * vx + vy * vy;              
            if (mag > 1) {
              t = 1 / (float)Math.sqrt(mag);   
            } 
            ball[BALL_TIME] -= t;

            // store the original position for cross-boundary tests later
            vx = ball[BALL_X];
            vy = ball[BALL_Y];
            
            // move the ball
            ball[BALL_VY] += t * GRAVITY;
            ball[BALL_Y] += t * ball[BALL_VY];
            ball[BALL_X] += t * ball[BALL_VX];
            
            // enter ramp tests
            if (ball[BALL_X] >= 200 && ball[BALL_X] <= 290) { // left ramp 
              if (ball[BALL_Y] < 240 && vy >= 240) {
                ball[BALL_LAYER] = 1;
              } else if (ball[BALL_Y] >= 240 && vy < 240) {
                ball[BALL_LAYER] = 0;
              }
            }
            if (ball[BALL_X] >= 360 && ball[BALL_X] <= 450) { // middle ramp
              if (ball[BALL_Y] < 310 && vy >= 310) {
                ball[BALL_LAYER] = 1;
              } else if (ball[BALL_Y] >= 310 && vy < 310) {
                ball[BALL_LAYER] = 0;
              }
            }
            if (ball[BALL_X] >= 627 && ball[BALL_X] <= 705) { // right ramp
              if (ball[BALL_Y] < 350 && vy >= 350) {
                ball[BALL_LAYER] = 1;
              } else if (ball[BALL_Y] >= 350 && vy < 350) {
                ball[BALL_LAYER] = 0;
              }
            }
            
            // lower left gate            
            if (lowerLeftGateEnabled 
                && ball[BALL_X] >= 49 && ball[BALL_X] <= 102
                && ball[BALL_Y] > 907 && vy <= 907) {
              ball[BALL_Y] = vy;
              ball[BALL_VY] = 0;
              ball[BALL_VX] = 2;
            }
            
            // rail gate
            if (ball[BALL_LAYER] == 1
                && railGateEnabled
                && ball[BALL_X] >= 47 && ball[BALL_X] <= 135
                && ball[BALL_Y] > 481 && vy <= 481) {
              ball[BALL_Y] = vy;
              ball[BALL_VY] = 0;
              ball[BALL_VX] = -2;
            }
            
            // exit left/right bottom of rail tracks
            if (ball[BALL_LAYER] == 1 && ball[BALL_Y] >= 805
                && ((ball[BALL_X] >= 90 && ball[BALL_X] <= 155) 
                  || (ball[BALL_X] >= 605 && ball[BALL_X] <= 660))) {
              ball[BALL_LAYER] = ball[BALL_VX] = ball[BALL_VY] = 0; 
              score += multiplier * 25;
            }
            
            // top barriers
            if (ball[BALL_LAYER] == 0 && ball[BALL_Y] <= 100) {              
              if (ball[BALL_X] > 653 && vx <= 653) {
                ball[BALL_X] = 653;
                if (ball[BALL_VX] > 0) {
                  ball[BALL_VX] = -ball[BALL_VX];
                }                
              } 
              if (ball[BALL_X] < 415 && vx >= 415) {
                ball[BALL_X] = 415;
                if (ball[BALL_VX] < 0) {
                  ball[BALL_VX] = -ball[BALL_VX];
                }
              }
            }
            
            // left-top hole suction
            vx = ball[BALL_X] - 32;
            vy = ball[BALL_Y] - 52;
            if (vx * vx + vy * vy <= 1225) {
              if (ball[BALL_STUCK] == 0) {
                ball[BALL_STUCK] = 128;
                score += multiplier * 25;
              }
              if (ball[BALL_STUCK] > 80) {
                ball[BALL_X] = 32;
                ball[BALL_Y] = 52;
                ball[BALL_VX] = ball[BALL_VY] = 0;
              } else {
                ball[BALL_X] = 475;
                ball[BALL_Y] = 369;
                railGateEnabled = true;
                lowerLeftGateEnabled = false;
              }
            }
            
            // left rail hole suction
            vx = ball[BALL_X] - 32;
            vy = ball[BALL_Y] - 613;
            if (vx * vx + vy * vy <= 1225) {
              if (ball[BALL_STUCK] == 0) {
                ball[BALL_STUCK] = 128;
                score += multiplier * 25;
              }
              if (ball[BALL_STUCK] > 80) {
                ball[BALL_X] = 32;
                ball[BALL_Y] = 613;
                ball[BALL_LAYER] = ball[BALL_VX] = ball[BALL_VY] = 0;
                railGateEnabled = false;
              } else {
                ball[BALL_X] = 475;
                ball[BALL_Y] = 369;
              }
            }
            
            // middle track end hole suction
            vx = ball[BALL_X] - 656;
            vy = ball[BALL_Y] - 523;
            if (vx * vx + vy * vy <= 1225) {
              if (ball[BALL_STUCK] == 0) {
                ball[BALL_STUCK] = 128;
                score += multiplier * 10;
              }
              if (ball[BALL_STUCK] > 80) {
                ball[BALL_X] = 656;
                ball[BALL_Y] = 523;
                ball[BALL_VX] = ball[BALL_VY] = 0;
              } else {
                ball[BALL_X] = 624;
                ball[BALL_Y] = 590;
                ball[BALL_LAYER] = 0;
              }
            }
            
            // center hole suction              
            vx = ball[BALL_X] - 475;
            vy = ball[BALL_Y] - 369;
            if (vx * vx + vy * vy <= 1225) {              
              if (ball[BALL_STUCK] == 0) {
                ball[BALL_STUCK] = 80;
                score += multiplier * 5;
              } 
              if (ball[BALL_STUCK] >= 48) {
                ball[BALL_X] = 475;
                ball[BALL_Y] = 369;
                ball[BALL_VX] = ball[BALL_VY] = 0;
              } else {
                ball[BALL_VX] = -4;
                ball[BALL_VY] = 8;
              }
            }   
            
            // right hole suction  
            vx = ball[BALL_X] - 624;
            vy = ball[BALL_Y] - 590;
            if (vx * vx + vy * vy <= 1225) {              
              if (ball[BALL_STUCK] == 0) {
                ball[BALL_STUCK] = 80;
                score += multiplier * 5;
              } 
              if (ball[BALL_STUCK] >= 48) {
                ball[BALL_X] = 624;
                ball[BALL_Y] = 590;
                ball[BALL_VX] = ball[BALL_VY] = 0;
              } else {
                ball[BALL_VX] = -4;
                ball[BALL_VY] = 8;
              }
            }
            
            // lower left hole suction
            vx = ball[BALL_X] - 77;
            vy = ball[BALL_Y] - 955;
            if (vx * vx + vy * vy <= 1225) {              
              if (ball[BALL_STUCK] == 0) {
                score += multiplier * 25;
                ball[BALL_STUCK] = 80;
              } 
              if (ball[BALL_STUCK] >= 48) {                
                ball[BALL_X] = 77;
                ball[BALL_Y] = 955;
                ball[BALL_VX] = ball[BALL_VY] = 0;
                lowerLeftGateEnabled = true;
              } else {
                ball[BALL_VY] = -12;
              }
            }
            
            // plunger collision test          
            vx = ball[BALL_X] - 730;
            vy = ball[BALL_Y] - 854;
            if (vx * vx + vy * vy <= 1225) {  
              if (plungerStrike > 0) {
                ball[BALL_VY] = -plungerStrike;          
              } else if (ball[BALL_VY] > 0) {
                ball[BALL_VY] = 0;
                ball[BALL_X] = 730;
                ball[BALL_Y] = 854;                
              }
            } 
            
            // ball slowly unsticks when stuck in suction hole
            if (ball[BALL_STUCK] > 0 && (cameraOnTarget || cameraVy != 4)) {
              ball[BALL_STUCK]--;
            }            
            
            // item collision test
            if (ball[BALL_LAYER] == 0) {
              for(j = 0; j < ITEMS; j++) {
                if (itemsTable[j][2] == 0) {
                  vx = ball[BALL_X] - itemsTable[j][0];
                  vy = ball[BALL_Y] - itemsTable[j][1];
                  if (vx * vx + vy * vy < 900) {
                    // item collision
                    score += multiplier * 25;
                    itemsTable[j][2] = 1;
                    for(k = 0; k <= ITEMS; k++) { // check if group complete
                      if (k == ITEMS) {
                        
                        score += multiplier * 100;
                        
                        // group complete; restore group
                        for(k = 0; k < ITEMS; k++) {
                          if (itemsTable[j][3] == itemsTable[k][3]) {
                            itemsTable[k][2] = 0;
                          }
                        }
                        
                        if (itemsTable[j][3] == 0) {
                          if (multiplier < 4) {
                            multiplier++;
                          }
                        } else if (itemsTable[j][3] == 1) {
                          
                          score += multiplier * 125;
                          
                          // create extra balls
                          if (ballCount < 3) {
                            ball2 = balls[ballCount++] = new float[8];
                            ball2[BALL_X] = 475;
                            ball2[BALL_Y] = 369;
                          }
                          if (ballCount < 3) {
                            ball2 = balls[ballCount++] = new float[8];
                            ball2[BALL_X] = 624;
                            ball2[BALL_Y] = 590;
                          }
                        }                        
                        break;
                      } else if (itemsTable[j][3] == itemsTable[k][3] 
                          && itemsTable[k][2] == 0) {
                        // group not complete yet
                        break;
                      }
                    }
                  }
                }
              }
            }
            
            boolean first = true;
            boolean collision = false;
            do {
              // test for collision with points in layer
              x1 = ((int)ball[BALL_X] - 20) >> 5;
              x2 = ((int)ball[BALL_X] + 20) >> 5;                            
              y2 = ((int)ball[BALL_Y] + 20) >> 5;     
              y = ((int)ball[BALL_Y] - 20) >> 5;               
              if (y < 0) {
                y = 0;
              }              
              if (x1 < 0) {
                x1 = 0;
              }

              fx = 0;
              fy = 0;
              collision = false;
              for(; y <= y2; y++) {
                for(x = x1; x <= x2; x++) {
                  box = layers[(int)ball[BALL_LAYER]][y][x];
                  for(z = boxSizes[(int)ball[BALL_LAYER]][y][x] - 1; 
                      z >= 0; z--) {
                    vx = ball[BALL_X] - box[z][0];
                    vy = ball[BALL_Y] - box[z][1];
                    if (vx * vx + vy * vy <= BALL_RADIUS2) {                    
                      fx += vx;
                      fy += vy;
                      collision = true;                    
                    }
                  }
                }
              }
              
              boolean flipperHit = false;
              
              // left flipper collision test
              for (float angle = leftFlipperAngle 
                  + (leftFlipperCounter > 0 
                      && leftFlipperCounter <= FLIPPER_DELAY ? .3f : 0);
                  angle >= leftFlipperAngle; angle -= .006f) {
                float sin = (float)Math.sin(angle);
                float cos = (float)Math.cos(angle);
                float X1 = 126 * cos + 21 * sin;
                float Y1 = 126 * sin - 21 * cos;                                                             
                vx = ball[BALL_X] - X1 - 221;
                vy = ball[BALL_Y] - Y1 - 949;
                float px = -21 * cos + 21 * sin - X1;
                float py = -21 * sin - 21 * cos - Y1;
                mag = (vx * px + vy * py) / (px * px + py * py);
                if (mag >= 0 && mag <= 1) {                
                  vx -= mag * px;
                  vy -= mag * py;                
                  mag = vx * vx + vy * vy;
                  if (mag <= BALL_RADIUS2) {                    
                    fx += vx;
                    fy += vy;                    
                    hit = collision = true; 
                    flipperHit = leftFlipperCounter > 0 
                        && leftFlipperCounter <= FLIPPER_DELAY;
                  }
                }
              }
              
              // right flipper collision test
              for (float angle = rightFlipperAngle 
                  + (rightFlipperCounter > 0 
                      && rightFlipperCounter <= FLIPPER_DELAY ? .3f : 0);
                  angle >= rightFlipperAngle; angle -= .006f) {
                float sin = (float)Math.sin(angle);
                float cos = (float)Math.cos(angle);
                float X1 = 126 * cos + 21 * sin;
                float Y1 = 126 * sin - 21 * cos;                                                             
                vx = ball[BALL_X] + X1 - 540;
                vy = ball[BALL_Y] - Y1 - 949;
                float px = 21 * cos - 21 * sin + X1;
                float py = -21 * sin - 21 * cos - Y1;
                mag = (vx * px + vy * py) / (px * px + py * py);
                if (mag >= 0 && mag <= 1) {                
                  vx -= mag * px;
                  vy -= mag * py;                
                  mag = vx * vx + vy * vy;
                  if (mag <= BALL_RADIUS2) {                    
                    fx += vx;
                    fy += vy;                    
                    hit = collision = true; 
                    flipperHit = rightFlipperCounter > 0 
                        && rightFlipperCounter <= FLIPPER_DELAY;
                  }
                }
              }

              if (collision) {
                
                mag = (float)Math.sqrt(fx * fx + fy * fy);
                fx /= mag;
                fy /= mag;                               
                if (first) {
                  first = false;                    
                  fx += ((float)Math.random() - 0.5f) / 50;
                  fy += ((float)Math.random() - 0.5f) / 50;
                  mag = DAMPENING * (ball[BALL_VX] * fx 
                      + ball[BALL_VY] * fy);
                  ball[BALL_VX] -= mag * fx;
                  ball[BALL_VY] -= mag * fy;
                  
                  if (ball[BALL_LAYER] == 0) {
                    
                    // collision with moving flipper test
                    if (flipperHit) {                       
                      if (ball[BALL_VY] > 0) {
                        ball[BALL_VY] = -ball[BALL_VY];
                      }
                      ball[BALL_VY] -= FLIPPER_VELOCITY;                    
                    } else {

                      // collision with right bumper test
                      if (rightBumper == 0) {                    
                        vx = ball[BALL_X] - 600;
                        vy = ball[BALL_Y] - 236;                     
                        mag = vx * vx + vy * vy;
                        if (mag < 4700) {
                          mag = BUMPER_VELOCITY / (float)Math.sqrt(mag);
                          ball[BALL_VX] = mag * vx;
                          ball[BALL_VY] = mag * vy;
                          rightBumper = 8; 
                          score += multiplier * 10;
                        }
                      }                      
                      
                      // collision with left bumper test  
                      if (leftBumper == 0) {                    
                        vx = ball[BALL_X] - 460;
                        vy = ball[BALL_Y] - 172;                    
                        mag = vx * vx + vy * vy;
                        if (mag < 4700) {
                          mag = BUMPER_VELOCITY / (float)Math.sqrt(mag);
                          ball[BALL_VX] = mag * vx;
                          ball[BALL_VY] = mag * vy;
                          leftBumper = 8; 
                          score += multiplier * 10;
                        }
                      }

                      // collision with right slingshot
                      if (rightSlingshot == 0) {
                        vx = ball[BALL_X] - 535;
                        vy = ball[BALL_Y] - 778;
                        if (vx * vx + vy * vy < 6972) {
                          ball[BALL_VX] = -22.35f;
                          ball[BALL_VY] = -8.75f;
                          rightSlingshot = 8;   
                          score += multiplier * 10;
                        }
                      }                      
                      
                      // collision with left slingshot
                      if (leftSlingshot == 0) {
                        vx = ball[BALL_X] - 218;
                        vy = ball[BALL_Y] - 778;
                        if (vx * vx + vy * vy < 6972) {
                          ball[BALL_VX] = 22.35f;
                          ball[BALL_VY] = -8.75f;
                          leftSlingshot = 8;    
                          score += multiplier * 10;
                        }
                      }
                    }                                    
                  }
                }         
                ball[BALL_X] += fx;
                ball[BALL_Y] += fy;
              }
            } while(collision);
          } while(ball[BALL_TIME] > 0);         
        }
        
        if (ballCount > 0) {
          // compute cameraY
          cameraOnTarget = true;
          maxBallY = 280 - maxBallY;
          if (maxBallY > 0) {
            maxBallY = 0;
          } else if (maxBallY < -440) {
            maxBallY = -440;
          }
          if (cameraY > maxBallY) {
            if (cameraY - maxBallY > cameraVy) {
              cameraY -= cameraVy;
              cameraOnTarget = false;
            } else { 
              cameraY = maxBallY;            
            }
          } else if (cameraY < maxBallY) {
            if (cameraY - maxBallY < -cameraVy) {
              cameraY += cameraVy;
              cameraOnTarget = false;
            } else {
              cameraY = maxBallY;            
            }
          }
        } 
        
        if (lastScore / EXTRA_BALL_BONUS < score / EXTRA_BALL_BONUS) {
          // extra ball awarded
          extraBalls++;
        }
        lastScore = score;

        // -- update ends ------------------------------------------------------

      } while(nextFrameStartTime < System.nanoTime());

      // -- render starts ------------------------------------------------------
            
      g.translate(0, cameraY);
      
      // draw layer 0
      g.drawImage(images[IMAGE_LAYER_0], 0, 0, null);
      
      // draw items
      for(j = 0; j < ITEMS; j++) {
        if (itemsTable[j][2] == 0) {   
          g.setColor(itemsTable[j][3] != 1 ? Color.GRAY : Color.WHITE);
          g.fillOval(itemsTable[j][0] - 10, itemsTable[j][1] - 10, 20, 20);
        }
      }      
        
      // draw left flipper         
      g.translate(219, 948);
      g.scale(-1, 1);
      g.rotate(-leftFlipperAngle);
      g.drawImage(images[IMAGE_FLIPPER], -156, -52, null);
      g.setTransform(transform);
      g.translate(0, cameraY);

      // draw right flipper
      g.translate(538, 948);
      g.rotate(-rightFlipperAngle);
      g.drawImage(images[IMAGE_FLIPPER], -156, -52, null);
      g.setTransform(transform);
      g.translate(0, cameraY);          

      // draw lower left gate      
      if (lowerLeftGateEnabled) {
        g.drawImage(images[IMAGE_GATE], 28, 897, null);
      }

      // draw rail gate
      if (railGateEnabled) {
        g.drawImage(images[IMAGE_GATE], 55, 470, null);
      }
      
      // draw lit right bumper
      if (rightBumper > 0) {
        g.drawImage(images[IMAGE_BUMPER], 490, 122, null);
      }      

      // draw lit left bumper
      if (leftBumper > 0) {
        g.drawImage(images[IMAGE_BUMPER], 346, 58, null);
      }

      // draw lit right slingshot
      if (rightSlingshot > 0) {
        g.drawImage(images[IMAGE_SLINGSHOT], 438, 670, null);
      }
      
      // draw lit left slingshot
      if (leftSlingshot > 0) {
        g.drawImage(images[IMAGE_SLINGSHOT], 90, 670, null);
      }      
        
      // draw balls on layer 0
      for(i = ballCount - 1; i >= 0; i--) {
        ball = balls[i];
        if (ball[BALL_LAYER] == 0) {
          g.drawImage(images[IMAGE_BALL], (int)(ball[BALL_X] - 84), 
              (int)(ball[BALL_Y] - 84), null);
        }
      }
        
      // draw plunger
      g.drawImage(images[IMAGE_PLUNGER], 698, 842 + plungerX, null);
      
      // draw layer 1
      g.drawImage(images[IMAGE_LAYER_1], 0, 0, null);
      
      // draw balls on layer 1
      for(i = ballCount - 1; i >= 0; i--) {
        ball = balls[i];
        if (ball[BALL_LAYER] == 1) {
          g.drawImage(images[IMAGE_BALL], (int)(ball[BALL_X] - 84), 
              (int)(ball[BALL_Y] - 84), null);
        }
      }

      // draw HUD (Linha de baixo.)
      g.setTransform(transform);
      g.setColor(Color.RED);
      g.fillRect(0, 560, 800, 40);  
      g.setColor(Color.WHITE); 
      g.drawString("Video Pinball", 250,595);
      
      g.setColor(Color.ORANGE); 
      g.drawString("x", 152, 595);
      g.drawString(String.valueOf(score * 1000), 563, 595);
      g.drawString(String.valueOf(multiplier), 128, 595);
      g.drawString(String.valueOf(extraBalls), 16, 595);    
      
      // -- render ends --------------------------------------------------------

      // show the hidden buffer
      if (g2 == null) {
        g2 = (Graphics2D)getGraphics();        
      } else {
        g2.drawImage(images[IMAGE_BUFFER], 0, 0, null);
      }

      // burn off extra cycles
      while(nextFrameStartTime - System.nanoTime() > 0) {
        Thread.yield();
      }
    }
  }
  
  @Override
  public boolean handleEvent(Event e) {
    return a[e.key] = e.id == 401;
  }

  // to run in window, uncomment below
  public static void main(String[] args) throws Throwable {
    javax.swing.JFrame frame = new javax.swing.JFrame("Demon Attack 4K");
    frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    a applet = new a();
    applet.setPreferredSize(new java.awt.Dimension(810, 615));
    frame.add(applet, java.awt.BorderLayout.CENTER);
    frame.setResizable(false);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    Thread.sleep(250);
    applet.start();
  }

}