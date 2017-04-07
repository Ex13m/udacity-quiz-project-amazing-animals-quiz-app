package com.example.android.amazinganimalsquiz.amphibians;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.example.android.amazinganimalsquiz.MainActivity;
import com.example.android.amazinganimalsquiz.R;

public class MexicanAxolotl extends AppCompatActivity {

    private ImageSwitcher mImageSwitcher;

    // массив картинок
    private int[] mImageIds = {R.drawable.mexicanaxolotl1, R.drawable.mexicanaxolotl2, R.drawable.mexicanaxolotl3};

    private int mCurIndex;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_mexican_axolotl);

            mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

            Animation slideInLeftAnimation = AnimationUtils.loadAnimation(this,
                    android.R.anim.slide_in_left);
            Animation slideOutRight = AnimationUtils.loadAnimation(this,
                    android.R.anim.slide_out_right);

            mImageSwitcher.setInAnimation(slideInLeftAnimation);
            mImageSwitcher.setOutAnimation(slideOutRight);

            mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

                @Override
                public View makeView() {

                    ImageView imageView = new ImageView(MexicanAxolotl.this);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setAdjustViewBounds(true);
                    //android:adjustViewBounds="true"

                    ViewGroup.LayoutParams params = new ImageSwitcher.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                    imageView.setLayoutParams(params);
                    return imageView;
                }
            });

            mCurIndex = 0;
            mImageSwitcher.setImageResource(mImageIds[mCurIndex]);
        }

        public void onClick(View v) {
            if (mCurIndex == mImageIds.length - 1) {
                mCurIndex = 0;
                mImageSwitcher.setImageResource(mImageIds[mCurIndex]);
            } else {
                mImageSwitcher.setImageResource(mImageIds[++mCurIndex]);
            }
        }

    }

