/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson2.builder;

/**
 *
 * @author sommovir
 */
public class GamePG {

    private String name;
    private String type;
    private int hp;
    private int pdef;
    private int cdef;

    public GamePG(String name, String type, int hp, int pdef, int cdef) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.pdef = pdef;
        this.cdef = cdef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPdef() {
        return pdef;
    }

    public void setPdef(int pdef) {
        this.pdef = pdef;
    }

    public int getCdef() {
        return cdef;
    }

    public void setCdef(int cdef) {
        this.cdef = cdef;
    }

    public static class Builder {

        private String name;
        private String type;
        private int hp;
        private int pdef;
        private int cdef;

        private Builder() {
        }
        
        public static Builder create(){
            return new Builder();
        }
        
        
        
        public Builder name(String name){
            this.name = name;
            return this;
        }
        
        public Builder type(String type){
            this.type = type;
            return this;
        }
        
        public Builder hp(int hp){
            this.hp = hp;
            return this;
        }
        
        public Builder pdef(int pdef){
            this.pdef = pdef;
            return this;
        }
        
        public Builder cdef(int cdef){
            this.cdef= cdef;
            return this;
        }

        public GamePG build() {
            return new GamePG(name, type, hp, pdef, cdef);
        }
    }

}
