package com.jenkins.test.builder;

/**
 * Created by zhaobenbing@wanda.cn on 18/1/8.
 */

public class NetritionFacts {
  private int serveringSize;
  private int serverings;
  private int color;
  private int fat;
  private int sodium;
  private int price;

  public static class Builder {
    private int serveringSize;
    private int serverings;
    private int color;
    private int fat;
    private int sodium;
    private int price;

    public Builder(int serveringSize, int serverings) {
      this.serveringSize = serveringSize;
      this.serverings = serverings;
    }

    public Builder setColor(int color) {
      this.color = color;
      return this;
    }

    public Builder setFat(int fat) {
      this.fat = fat;
      return this;
    }

    public Builder setSodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder setPrice(int price) {
      this.price = price;
      return this;
    }

    public NetritionFacts build() {
      return new NetritionFacts(this);
    }
  }

  private NetritionFacts(Builder builder) {
    this.serveringSize = builder.serveringSize;
    this.serverings = builder.serverings;
    this.color = builder.color;
    this.fat = builder.fat;
    this.price = builder.price;
    this.sodium = builder.sodium;
  }
}
