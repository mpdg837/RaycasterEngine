# RaycasterEngine
Projekt silnika renderującego grafikę pseudo 3D za pomocą techniki tzw. raycastingu. Oprogramowanie wykonane w Javie, obłśuguje wiele poziomów i mimo tego że korzysta z techniki typowej dla Wolfensteina 3D przypomina swoim układem gry pokroju DOOM-a. W projekcie tym wykorzystano wiele optymalizacji, które umożliwiły uruchomienie tego silnika na JVM

# Wymagania

Silnik wymagado uruchomienia

* Java 8.0
* JavaFX

Projekt przystosowany do uruchamiania jedynie w systemach z rodziny Windows (jeżeli chodzi o pliki jar).

# Przykład działania
Przykładowe obrazy wygenerowane przez ten silnik znajdują się poniżej:

<p align='center'>
<img src="https://raw.githubusercontent.com/mpdg837/RaycasterEngine/main/3D1.png"  width="700" height="400">
</p>

Silnik wspiera wiele poziomów, spritey (zarówno obrotowe - odwracające się w stronę kamery jak i nieruchome tworzące płoty itp). Ściany tworzone są zarówno z bloków jak i okrągłych kolumn oraz z skoksów. Silnik przez to mimo technicznie mniejszych możliwości od silnika Doom-a (BSP) umożliwia tworzenie wielopoziomowych poziomów o podobnym poziomie detali.

<p align='center'>
<img src="https://raw.githubusercontent.com/mpdg837/RaycasterEngine/main/3D2.png"  width="700" height="400">
</p>

Dla optymalizacji tak aby nie stosować bibliotek typu OpenGL itp. zastosowano jedynie przetwarzanie BitmapRaster-a, konwertując tablice int dwuwymairową na obraz. Przetwarzanie danych na tablicach int, umożliwia znacznie szybsze rysowanie niż stosowanie bibliotek Drawing z pakietu Swing. Aby szybciej liczyć funkcje trygonometryczne należało zasotoswać tablicowanie. Pomimo tego iż komputery są dzisiaj znacznie szybsze niż 30 lat temu to przez to, że sama Java (bez wspomagania innymi bibliotekami) nie jest zbyt dobrze przystosowana do efektywnego rysowania grafiki trzeba było stosować archaiczne metody optymalizacji.

Aby zmniejszyć ilość analizowanych promienii zamiast rysowania kolumn zastosowano autorską technikę rysowania trapezów. Dzięki można było analizować kilka razy mniej pojedynczych promieni, nie tracąc jakości. Niemniej zastosowanie tej optymalizacji powoduje wprowadzenie pewnych zniekształceń (trapezy te są albo prostokątami albo ają kąt rozwarcia 145 stopni).

<p align='center'>
<img src="https://raw.githubusercontent.com/mpdg837/RaycasterEngine/main/3D3.png"  width="700" height="400">
</p>

Udało się więc bez żadnego wspomagania bibliotekami 3D ani bibliotekami do rysowania generować obraz z prędkością nawet 50 FPS-ów, zachowując oczekiwany retro efekt.

<p align='center'>
<img src="https://raw.githubusercontent.com/mpdg837/RaycasterEngine/main/3D4.png"  width="700" height="400">
</p>
