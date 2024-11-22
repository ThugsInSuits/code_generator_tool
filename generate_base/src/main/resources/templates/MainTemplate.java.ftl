package org.example;

import java.util.Scanner;
/**
 * ACM模版输入
 * @author ${author}
 */
public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        <#if loop>
        while (scanner.hasNext()) {
        </#if>
            int n = scanner.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int sum = 0;
            for (int i : arr) {
                sum += i;
            }

            System.out.printf("${outputText}" + sum);
<#if loop>
        }
</#if>
        scanner.close();
    }
}