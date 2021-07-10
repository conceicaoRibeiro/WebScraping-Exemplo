package com.example.webscrapingnfl.scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TerceiroLink {
	public static void main(String[] args) throws IOException {
		
		String endereco = "https://www.infomoney.com.br/mercados";
		Document document = Jsoup.connect(endereco).get();

		String uri = "https://www.infomoney.com.br/mercados/bndes-da-mais-um-passo-para-efetivar-privatizacao-da-eletrobras-em-fevereiro/";
		Document doc = Jsoup.connect(uri).get();

		Elements link = document.getElementById("post-1664261").select("a[href]");
		for (Element element : link) {
			System.out.println(element.text());
		}
		System.out.println(link.attr("href"));

		Element subtitulo = doc.select("p.article-lead").first();
		Elements autor = doc.select("span.author-name");
		Elements data = doc.select("time[datetime]");

		
			System.out.println(subtitulo.text());
			System.out.println(autor.text());
			System.out.println(data.text());
	}

}
