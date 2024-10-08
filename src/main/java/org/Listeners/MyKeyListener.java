package org.Listeners;

import org.Controllers.RunningModeController;
import org.Domain.SpellType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter {
    private RunningModeController runningModeController;

    public MyKeyListener(RunningModeController controller) {
        this.runningModeController = controller;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                runningModeController.slideMagicalStaff(-8); // Move left
                break;
            case KeyEvent.VK_RIGHT:
                runningModeController.slideMagicalStaff(+8); // Move right
                break;
            case KeyEvent.VK_A:
                runningModeController.rotateMagicalStaff(-3); // Rotate counterclockwise (degrees)
                runningModeController.getGameSession().getMagicalStaff().setReleased(false);
                break;
            case KeyEvent.VK_D:
                runningModeController.rotateMagicalStaff(+3); // Rotate clockwise (degrees)
                runningModeController.getGameSession().getMagicalStaff().setReleased(false);
                break;
            case KeyEvent.VK_H:
                runningModeController.getGameSession().useSpell(SpellType.HEX);
                break;
            case KeyEvent.VK_Q:
                runningModeController.getGameSession().useSpell(SpellType.FELIX_FELICIS);
                break;
            case KeyEvent.VK_T:
                runningModeController.getGameSession().useSpell(SpellType.STAFF_EXPANSION);
                break;
            case KeyEvent.VK_E:
                runningModeController.getGameSession().useSpell(SpellType.OVERWHELMING_FIREBALL);
                break;
            case KeyEvent.VK_W:
                runningModeController.getGameSession().triggerBall();
                break;
            case KeyEvent.VK_Z:
                runningModeController.comm.sendSpell("Spell: {spellType: hp}");
                break;
            case KeyEvent.VK_X:
                runningModeController.comm.sendSpell("Spell: {spellType: iv}");
                break;
            case KeyEvent.VK_C:
                runningModeController.comm.sendSpell("Spell: {spellType: da}");
                break;
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                runningModeController.slideMagicalStaff(0); // Move left
                break;
            case KeyEvent.VK_RIGHT:
                runningModeController.slideMagicalStaff(0); // Move right
                break;
            case KeyEvent.VK_A:
                runningModeController.rotateMagicalStaff(3); // Rotate counterclockwise
                runningModeController.getGameSession().getMagicalStaff().setReleased(true);
                break;
            case KeyEvent.VK_D:
                runningModeController.rotateMagicalStaff(-3); // Rotate clockwise
                runningModeController.getGameSession().getMagicalStaff().setReleased(true);
                break;

            case KeyEvent.VK_P:
                runningModeController.volume(1);
                break;
            case KeyEvent.VK_O:
                runningModeController.volume(-1);
                break;
        }

    }
}
