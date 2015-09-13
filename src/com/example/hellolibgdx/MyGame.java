package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGame implements ApplicationListener {
	Stage stage;
	TextureAtlas atlas;
	JindutiaoImage jindutiaoImage;
	AssetManager manager;//����һ����Դ������
	
	TextureRegion bgRegion;//����ͼƬ
	Image bgImage;
	@Override
	public void create() {
		stage = new Stage(480, 800, false);
		atlas = new TextureAtlas(Gdx.files.internal("data/loading.atlas"));
		jindutiaoImage = new JindutiaoImage(atlas.findRegion("xiaotiao"));
		jindutiaoImage.setPosition(0, 400);
		
		bgRegion = atlas.findRegion("bg");
		bgImage = new Image(bgRegion);
		stage.addActor(bgImage);
		stage.addActor(jindutiaoImage);
		manager = new AssetManager();//��Դ�������ĳ�ʼ��
		load();
	}

	/**
	 * ������Դ
	 */
	public void load(){
		int i;
		for(i = 0 ; i <= 30 ; ++i){
			manager.load("data/test" + i + ".jpg",Texture.class);//����Դ���ص�Ԥ���ض���
		}
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// ���ñ���Ϊ��ɫ
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// ����
		manager.update();//����Դ���ص��ڴ���
		float progress = manager.getProgress();//��ȡĿǰ������Դ�İٷֱ�
		jindutiaoImage.setWidth(480 * progress);
		stage.act();
		stage.draw();
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
