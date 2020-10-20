package com.example.p533;

public class Movie {

    String rank;
    String movieNm;
    String openDt;
    String salesAcc;

    public Movie() {
    }

    public Movie(String rank, String movieNm, String openDt, String salesAcc) {
        this.rank = rank;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.salesAcc = salesAcc;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getSalesAcc() {
        return salesAcc;
    }

    public void setSalesAcc(String salesAcc) {
        this.salesAcc = salesAcc;
    }
}
