package edu.ilstu;

import java.util.Scanner; 

public class Password {

	
	final static int[] arr = {2,9,3,4,6,8,1,0};
	final static int passLength = 10;
	
	
	public static void main(String[] args) {
		
		
		Scanner keyboard = new Scanner(System.in);
		String encryptedPassword, decryptedPassword;
		
		boolean looping = true;
		int iteration = 1;
		
		System.out.println("Enter the password: ");
		String password = keyboard.nextLine();
		
		while (looping) {
		
			if ( iteration > 1) {
				
				System.out.println("Enter a new password: ");
				password = keyboard.nextLine(); 
			}
		
			if (IsValidLength(password) == true) {
				encryptedPassword = encrypt(password);
				System.out.println("\nThe encypted password is:  " + encryptedPassword);
				
				decryptedPassword = decrypt(encryptedPassword);
				System.out.println("\nThe decrypted password is: " + decryptedPassword);
				
				looping = false;
			}
			else
			{
				System.out.println("\nThe password must be at least " + passLength + " characters long");
				iteration++;
			}
		}
	
		keyboard.close();
    }
		

	public static boolean IsValidLength(String password) {
		
			boolean acceptedPassword = false;
			
			if ((password.length() - 1) >= getMinimumLength())
				acceptedPassword = true;
			
			return acceptedPassword;
		}
	
	public static int getMinimumLength() {
			
			return passLength;	
		}


	public static String encrypt(String password) {
	
		StringBuilder ePassword = new StringBuilder(password);
		char ch;
		int idx, index;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i + 1; j < arr.length; j++) {
					
				if (j < arr.length - 1) {
						
					idx = arr[i];
					ch = password.charAt(idx);
					index = arr[j];					
				} 
				else {
						
					idx = arr[arr.length - 1];
					index = arr[idx];
					ch = password.charAt(idx);
					ePassword.setCharAt(index, ch);
					
					idx = arr[arr.length - index];
					ch = password.charAt(idx);
					index = 0;
				}
					
				ePassword.setCharAt(index, ch);
				break;
			}
		}
		
		return ePassword.toString();
	}


	public static String decrypt(String password) {
	
		StringBuilder dPassword = new StringBuilder(password);
		char ch;
		int idx, index;
		
		for (int i = arr.length; i >= 0; i--) {
				
				for (int j = i - 1; j >= 0; j--) {
						
					if (j >= arr.length - 1) {
						
						idx = arr.length - 1;
						index = arr[idx];
						ch = password.charAt(idx);
						dPassword.setCharAt(index, ch);
						
						idx = arr[0];
						ch = password.charAt(idx);
						index = 0;				
					} 
					else {
							
						idx = arr[i];
						ch = password.charAt(idx);
						index = arr[j];
					}
						
					dPassword.setCharAt(index, ch);
					break;
				}
			}
			
			return dPassword.toString();	
		}
		
		
	
	}

