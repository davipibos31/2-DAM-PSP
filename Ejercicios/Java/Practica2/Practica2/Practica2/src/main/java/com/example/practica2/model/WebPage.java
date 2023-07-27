package com.example.practica2.model;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class WebPage {

    private String nombre;
    private String url;
    @SuppressWarnings("Convert2Diamond")
    private List<String> list = new List<String>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @NotNull
        @Override
        public Iterator<String> iterator() {
            //noinspection ConstantConditions
            return null;
        }

        @NotNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NotNull
        @Override
        public <T> T[] toArray(@NotNull T[] a) {
            //noinspection ConstantConditions
            return null;
        }

        @Override
        public boolean add(String s) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NotNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NotNull Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NotNull Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NotNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NotNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public String get(int index) {
            return null;
        }

        @Override
        public String set(int index, String element) {
            return null;
        }

        @Override
        public void add(int index, String element) {

        }

        @Override
        public String remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @NotNull
        @Override
        public ListIterator<String> listIterator() {
            //noinspection ConstantConditions
            return null;
        }

        @NotNull
        @Override
        public ListIterator<String> listIterator(int index) {
            //noinspection ConstantConditions
            return null;
        }

        @NotNull
        @Override
        public List<String> subList(int fromIndex, int toIndex) {
            //noinspection ConstantConditions
            return null;
        }
    };

    public String getNombre() {
        return nombre;
    }

    @SuppressWarnings("unused")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    @SuppressWarnings("unused")
    public void setUrl(String url) {
        this.url = url;
    }

    @SuppressWarnings("UnusedReturnValue")
    public List<String> getList() {
        return list;
    }

    @SuppressWarnings("unused")
    public void setList(List<String> list) {
        this.list = list;
    }

    public WebPage(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }
}
