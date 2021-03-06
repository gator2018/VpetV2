package com.roel.vpetv2.PetStatus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by roel on 4/18/17.
 */

public class HealthStatus extends Actor {

    public float HealthStat;
    private Texture health;
    private Preferences update;


    public HealthStatus()
    {

        update = Gdx.app.getPreferences("Status");
        HealthStat = update.getFloat("HealthStatus");
        System.out.println("HealtStat(in class): "+ HealthStat);
        if(HealthStat>75)
            health = new Texture("healthSprites/ht1.png");
        else if (HealthStat>50)
            health  = new Texture(("healthSprites/ht2.png"));
        else if(HealthStat>25)
            health = new Texture(("healthSprites/ht3.png"));
        else
            health = new Texture(("healthSprites/ht4.png"));

    }


    public boolean updateStats(float foodStat)
    {
        if(foodStat <=0)
        {
            if(HealthStat <= 0)
                return true;
            else
                HealthStat -= 10;        // 0.5f
        }
        else if(foodStat > 50 && HealthStat<100)
        {
            HealthStat +=10;        //0.1f
        }
        return false;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        float healthy = (Gdx.graphics.getHeight()/3)+(health.getHeight()*8);
        float healthx = (Gdx.graphics.getWidth()/3)+(health.getWidth()*4.9f);
        batch.draw(health,healthx,healthy,Gdx.graphics.getWidth()/6,Gdx.graphics.getHeight()/10);

    }

    @Override
    public void act(float delta) {
        if(HealthStat>75)
            health = new Texture(("healthSprites/ht1.png"));
        else if(HealthStat>50)
            health = new Texture(("healthSprites/ht2.png"));
        else if(HealthStat>25)
            health = new Texture(("healthSprites/ht3.png"));
        else
            health = new Texture(("healthSprites/ht4.png"));
        super.act(delta);
    }
}
