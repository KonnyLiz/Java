<?xml version="1.0" encoding="ISO-8859-1"?>
<helpset>
        <title>Autentia Real Business Solutions. Tutorial JavaHelp</title>
        <maps>
                <!-- Página por defecto al mostrar la ayuda -->
                <homeID>introduccion</homeID>
		    <homeID>introduccion</homeID>
                <!-- Que mapa deseamos -->
                <mapref location="sga.jhm" />
        </maps>

        <!-- Las Vistas que deseamos mostrar en la ayuda -->
        <view>
                <!-- Deseamos una tabla de contenidos -->
                <name>Contenidodd</name>
                <!-- El tooltiptext de la vista -->
                <label>Tabla de contenidos</label>
                <type>javax.help.TOCView</type>
                <!-- El icono que se muesta -->
                <image>ContentIco</image>
                <!-- El fichero que la define -->
                <data>sgaTOC.xml</data>
        </view>

        <view xml:lang="es">
                <!-- Deseamos que se puedan realizar búsquedas -->
                <name>Buscar</name>
                <!-- El tooltiptext -->
                <label>Búsqueda</label>
                <!-- El icono que se muesta -->
                <image>SearchIco</image>
                <type>javax.help.SearchView</type>
                <data engine="com.sun.java.help.search.DefaultSearchEngine">
                        JavaHelpSearch
                </data>
        </view>

         <view mergetype="javax.help.SortMerge">
                <name>Index</name>
                <label>Index</label>
                <type>javax.help.IndexView</type>
                <data>Index.xml</data>
          </view>

       <view xml:lang="en" mergetype="javax.help.SortMerge">
            <name>glosario</name>
            <label>Glosario</label>
            <type>javax.help.GlossaryView</type>
            <data>glosario.xml</data>
       </view>

        <view>
            <name>Favoritos</name>
            <label>Favoritos</label>
            <type>javax.help.FavoritesView</type>
        </view>
    
    
       

        <!-- Definición de la ventana principal de la ayuda-->
        <presentation default="true" displayviews="true" displayviewimages="true">
                <name>MainWin</name>
                <!-- Dimensiones iniciales -->
                <size width="750" height="880" />
                <!-- Posición inicial -->
                <location x="200" y="200" />
                <!-- Título de la ventana -->
                <title>Sistema de Ayuda</title>

                <image>LogoIco</image>

                <!-- Definimos la barra de herramientas de la ventana -->
                <toolbar>
                        <!-- Permitimos ir a la página anterior -->
                        <helpaction image="BackwardIco">
                                javax.help.BackAction
                        </helpaction>

                        <!-- Permitimos ir a la página siguiente -->
                        <helpaction image="ForwardIco">
                                javax.help.ForwardAction
                        </helpaction>

                       

                        <helpaction>
                                javax.help.SeparatorAction
                        </helpaction>

                        <helpaction image="Home">
                                javax.help.HomeAction
                        </helpaction>

                        <helpaction image="Favoritos">
                                javax.help.FavoritesAction
                        </helpaction>

                        <helpaction image="Reload">
                                javax.help.ReloadAction
                        </helpaction>

                        <helpaction>
                                javax.help.SeparatorAction
                        </helpaction>

                        <!-- Permitimos imprimir el contenido -->
                        <helpaction image="PrintIco">
                                javax.help.PrintAction
                        </helpaction>
                        <!-- Permitimos configurar la impresión -->
                        <helpaction image="PrintSetupIco">
                                javax.help.PrintSetupAction
                        </helpaction>
                </toolbar>
        </presentation>
</helpset>



