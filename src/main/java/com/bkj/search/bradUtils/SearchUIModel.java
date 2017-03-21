package com.bkj.search.utils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class SearchUIModel implements IFileStore, Saveable {

    private List<String> openFiles;
    private List<FileInvertedIndex> indexedFiles;

    private SearchUIModel(SearchUIModelBuilder.ModelSettings settings) {
        openFiles = new ArrayList<>();
        openFiles.addAll(settings.openFileList);

        indexedFiles = new ArrayList<>();
    }

    /**
     * Returns a List of the currently indexed files
     * @return List of indexed files
     */
    @Override
    public List<FileInvertedIndex> getIndexedFiles() {
        return indexedFiles;
    }


    @Override
    public List<String> getOpenFiles() {
        return openFiles;
    }

    /**
     * Change the indexedFiles List to a different list
     * @param indexedFiles A List of indexed files
     */
    @Override
    public void setIndexedFiles(List<FileInvertedIndex> indexedFiles) {
        this.indexedFiles = indexedFiles;
    }

    /**
     * Adds a Inverted Index to the index list
     * @param fii a Single FileInvertedIndex to add to the list
     */
    @Override
    public void addIndexedFile(FileInvertedIndex fii) {
        this.indexedFiles.add(fii);
    }

    @Override
    public void removeIndexedFile(int i) { this.indexedFiles.remove(i); }

    @Override
    public void saveToJson() {

        SearchUIModelBuilder sui = new SearchUIModelBuilder()
                .setIndexedFiles(indexedFiles)
                .setOpenFiles(openFiles);

        Gson g = new Gson();
        File modelFile = new File("model.json");
        if (modelFile.exists() && modelFile.canWrite()) modelFile.delete();

        try (FileWriter fw = new FileWriter(modelFile)) {
            System.out.printf("Saving model to disk%n");
            fw.write(g.toJson(sui.settings));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class SearchUIModelBuilder implements IBuildable<SearchUIModel, SearchUIModelBuilder> {
        ModelSettings settings;

        private class ModelSettings  {
            List<String> openFileList;
            List<FileInvertedIndex> indexedFiles;

            ModelSettings() {
                openFileList = new ArrayList<>();
                indexedFiles = new ArrayList<>();
            }

        }

        public SearchUIModelBuilder() {
            settings = new ModelSettings();
        }

        public SearchUIModelBuilder
        setOpenFiles(List<String> files) {
            for(String s : files) {
                settings.openFileList.add(s);
            }
            return this;
        }

        public SearchUIModelBuilder
        setIndexedFiles(List<FileInvertedIndex> indexes) {
            for(FileInvertedIndex fii : indexes) {
                settings.indexedFiles.add(fii);
            }
            return this;
        }

        @Override
        public SearchUIModel
        build() {
            return new SearchUIModel(settings);
        }

        @Override
        public SearchUIModelBuilder
        makeFromJson(FileReader fr) {
            Gson gson = new Gson();
            settings = gson.fromJson(fr, SearchUIModelBuilder.ModelSettings.class);
            return this;
        }
    }

}
