package com.example.practica2.utils;

import com.example.practica2.model.WebPage;
import javafx.scene.shape.Path;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FileUtils extends BufferedReader {

    public FileUtils(@NotNull Reader in, int sz) {
        super(in, sz);
    }

    public FileUtils(@NotNull Reader in) {
        super(in);
    }

    public static List<WebPage> loadPages(String file) {

        List<WebPage> list = new List<WebPage>() {
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
            public Iterator<WebPage> iterator() {
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
                return null;
            }

            @Override
            public boolean add(WebPage webPage) {
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
            public boolean addAll(@NotNull Collection<? extends WebPage> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NotNull Collection<? extends WebPage> c) {
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
            public WebPage get(int index) {
                return null;
            }

            @Override
            public WebPage set(int index, WebPage element) {
                return null;
            }

            @Override
            public void add(int index, WebPage element) {

            }

            @Override
            public WebPage remove(int index) {
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
            public ListIterator<WebPage> listIterator() {
                return null;
            }

            @NotNull
            @Override
            public ListIterator<WebPage> listIterator(int index) {
                return null;
            }

            @NotNull
            @Override
            public List<WebPage> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        return list;
    }
}
