package io.shine.tools.spigot.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class BookBuilder {
    private String writer, title;
    private List<String> pages;

    public BookBuilder(String writer, String title){
        this.writer = writer;
        this.pages = new ArrayList<>();
        this.title = title;
    }

    public BookBuilder addPage(String... page){
        for(String p : page){
            this.pages.add(p);
        }
        return this;
    }

    public ItemStack toItem(){
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setTitle(title);
        meta.setAuthor(writer);
        meta.setPages(pages);
        book.setItemMeta(meta);
        return book;
    }

}
