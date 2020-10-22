package com.example.ws;

public class Movie {
    String rank;
    String movieNm;
    String openDt;
    String audiAcc;

    public Movie() {
    }

    public Movie(String rank, String movieNm, String openDt, String audiAcc) {
        this.rank = rank;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiAcc = audiAcc;
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

    public String getAudiAcc() {
        return audiAcc;
    }

    public void setAudiAcc(String audiAcc) {
        this.audiAcc = audiAcc;
    }
}
