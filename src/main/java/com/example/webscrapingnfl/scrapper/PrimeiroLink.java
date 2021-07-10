package com.example.webscrapingnfl.scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PrimeiroLink {

	public static void main(String[] args) throws IOException {

		String endereco = "https://www.infomoney.com.br/mercados";
		Document document = Jsoup.connect(endereco).get();

		String uri = "https://www.infomoney.com.br/mercados/petrobras-banco-do-brasil-e-eletrobras-ganham-destaque-em-dia-de-b3-fechada-petrorio-aquisicao-da-rede-dor-tambem-no-radar/";
		Document doc = Jsoup.connect(uri).get();

		Elements link = document.getElementById("post-1664141").select("a[href]");
		for (Element element : link) {
			System.out.println(element.text());
		}
		System.out.println(link.attr("href"));

		Elements subtitulo = doc.getElementsByClass("article-lead");
		Elements autor = doc.select("span.author-name");
		Elements data = doc.select("time[datetime]");

		for (Element element : subtitulo) {
			System.out.println(element.text());
			System.out.println(autor.text());
			System.out.println(data.text());
		}
	}

}
