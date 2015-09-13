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
	AssetManager manager;//定义一个资源加载器
	
	TextureRegion bgRegion;//背景图片
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
		manager = new AssetManager();//资源加载器的初始化
		load();
	}

	/**
	 * 加载资源
	 */
	public void load(){
		int i;
		for(i = 0 ; i <= 30 ; ++i){
			manager.load("data/test" + i + ".jpg",Texture.class);//将资源加载到预加载队列
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
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏
		manager.update();//将资源加载到内存中
		float progress = manager.getProgress();//获取目前加载资源的百分比
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
