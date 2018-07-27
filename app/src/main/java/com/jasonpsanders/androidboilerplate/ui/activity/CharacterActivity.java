package com.jasonpsanders.androidboilerplate.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jasonpsanders.androidboilerplate.R;
import com.jasonpsanders.androidboilerplate.data.model.Character;

public class CharacterActivity extends BaseActivity {

  private static final String EXTRA_CHARACTER = "CharacterActivity.EXTRA_CHARACTER";

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.toolbar_collapsing) CollapsingToolbarLayout mCollapsingToolbar;

  private Character mCharacter;

  public static Intent getStartIntent(Context context, Character character) {
    Intent intent = new Intent(context, CharacterActivity.class);
    intent.putExtra(EXTRA_CHARACTER, character);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_character);
    ButterKnife.bind(this);
    mCharacter = getIntent().getParcelableExtra(EXTRA_CHARACTER);
    if (mCharacter == null) {
      throw new IllegalArgumentException("CharacterActivity requires a Character object!");
    }
    setupToolbar();
  }

  private void setupToolbar() {
    setSupportActionBar(mToolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      mCollapsingToolbar.setTitle(mCharacter.name);
    }
  }

}