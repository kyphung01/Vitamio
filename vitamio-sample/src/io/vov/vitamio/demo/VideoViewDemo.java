/*
 * Copyright (C) 2013 yixia.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.vov.vitamio.demo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoViewDemo extends Activity {

	/**
	 * TODO: Set the path variable to a streaming video URL or a local media file
	 * path.
	 */

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		Vitamio.isInitialized(getApplicationContext());


		setContentView(R.layout.videoview);
		Button btnPlay = (Button) findViewById(R.id.start);
		EditText txtPath = (EditText) findViewById(R.id.url);
		final String path;
		path = txtPath.getText().toString();

		btnPlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				playfunction();
//				Toast.makeText(VideoViewDemo.this, path, Toast.LENGTH_SHORT).show();
			}
		});

//		Button btnOpen = (Button) findViewById(R.id.button1);
//		btnOpen.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				playfunction();
////				Toast.makeText(VideoViewDemo.this, path, Toast.LENGTH_SHORT).show();
//
//			}
//		});



//		playfunction();

	}

	
	void playfunction(){
		EditText txtPath = (EditText) findViewById(R.id.url);
		String path="";
		path = txtPath.getText().toString();
//		String path = "";

//		 path="";
//		 path="http://24h-video.24hstatic.com/upload/2-2016/videoclip/2016-05-18/1463533116-mu_ballball.mp4";
//		 path = "/sdcard/Download/1.mkv";
//		path = "http://stream2.mecloud.vn/clip/2016/5/20/9/24/39d536a3cc4953316476d81ef87c75ff_360.mp4?e=1463746403&s=04UX4Zv6Y1E4fdxjHpqm9w&z=1463732003819584102";

//		String URLstring = "android.resource://" + getPackageName() + "/" +  R.raw.abc;
		 VideoView mVideoView;
		 EditText mEditText;
		mEditText = (EditText) findViewById(R.id.url);
		mVideoView = (VideoView) findViewById(R.id.surface_view);
		if (path.matches("")) {
			// Tell the user to provide a media file URL/path.
			Toast.makeText(VideoViewDemo.this, "Please edit VideoViewDemo Activity, and set path" + " variable to your media file URL/path", Toast.LENGTH_LONG).show();
			return;
		} else {
//			 * Alternatively,for streaming media you can use
//			  mVideoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+"abc.mp4"));

			mVideoView.setVideoPath(path);
			mVideoView.setMediaController(new MediaController(this));
			mVideoView.requestFocus();

			mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mediaPlayer) {
					// optional need Vitamio 4.0
					mediaPlayer.setPlaybackSpeed(1.0f);
				}
			});
		}
	}
	
}
