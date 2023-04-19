package com.mycompany.trabalhopaulinho;

import javax.swing.JOptionPane;

public class TrabalhoPaulinho {

    public static void main(String[] args) {

        int quant;

        quant = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de espaços que você quer inserir no array: "));
        int[] numbers = new int[quant];
        for (int i = 0; i < numbers.length; i++) {
            String input = JOptionPane.showInputDialog("Informe o número para a posição " + i + ":");
            numbers[i] = Integer.parseInt(input);
        }
        System.out.println("Array desordenado");
        for (int i = 0; i < numbers.length; i++) {

            System.out.println(numbers[i]);
        }
        System.out.println("\n\n\n");

        String input = JOptionPane.showInputDialog("Informe qual operação deseja realizar ('B' para utilizar o método"
                + "BubbleSort, 'S' para utilizar o método SelectionSort ou 'I' para usar o método InsertionSort): ");
        switch (input.toUpperCase()) {

            case "B":
                bubbleSort(numbers);
                System.out.println("Ordenado pelo bubble sort: ");
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;

            case "S":
                selectionSort(numbers);
                System.out.println("Ordenado pelo selection sort: ");
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;

            case "I":
                insertionSort(numbers);
                System.out.println("Ordenado pelo insertion sort: ");
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;

            default:
                System.out.println("Opção inválida, rode o código novamente e selecione ou B, S ou I");
        }
    }

    public static void bubbleSort(int[] arr) {
        long inicio = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        System.out.println("\nO tempo de execução para o bubbleSort foi de: " + tempoExecucao + " milésimos");
    }

    public static void selectionSort(int[] arr) {
        long inicio = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            int posMenor = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[posMenor]){
                    posMenor = j;
                }
            }
            if(posMenor != i){
                int aux = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = aux;
            }
        }
        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        System.out.println("\nO tempo de execução para o selectionSort foi de: " + tempoExecucao + " milésimos");
    }

    public static void insertionSort(int[] arr) {
        int chave, j;
        long inicio = System.nanoTime();
        for(int i = 1; i < arr.length; i++){
            chave = arr[i];
            for(j = i - 1;  j >= 0 && arr[j] > chave ; j-- ){
                arr[j+1] = arr[j];
            }
            arr[j+1] = chave;
        }
        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        System.out.println("\nO tempo de execução para o insertionSort foi de: " + tempoExecucao + " milésimos");
    }
}
