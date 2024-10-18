// eslint-disable-next-line no-undef
module.exports = {
  darkMode: ['class'],
  mode: 'jit',
  content: ['./src/**/*.{js,jsx,ts,tsx}'],
  theme: {
  	extend: {
  		borderRadius: {
  			lg: 'var(--radius)',
  			md: 'calc(var(--radius) - 2px)',
  			sm: 'calc(var(--radius) - 4px)'
  		},
  		colors: {
  			background: 'hsl(var(--background))',
  			foreground: 'hsl(var(--foreground))',
  			card: {
  				DEFAULT: 'hsl(var(--card))',
  				foreground: 'hsl(var(--card-foreground))'
  			},
  			popover: {
  				DEFAULT: 'hsl(var(--popover))',
  				foreground: 'hsl(var(--popover-foreground))'
  			},
  			primary: {
  				DEFAULT: 'hsl(var(--primary))',
  				foreground: 'hsl(var(--primary-foreground))'
  			},
  			secondary: {
  				DEFAULT: 'hsl(var(--secondary))',
  				foreground: 'hsl(var(--secondary-foreground))'
  			},
  			muted: {
  				DEFAULT: 'hsl(var(--muted))',
  				foreground: 'hsl(var(--muted-foreground))'
  			},
  			accent: {
  				DEFAULT: 'hsl(var(--accent))',
  				foreground: 'hsl(var(--accent-foreground))'
  			},
  			destructive: {
  				DEFAULT: 'hsl(var(--destructive))',
  				foreground: 'hsl(var(--destructive-foreground))'
  			},
        button: {
          DEFAULT: 'hsl(var(--button))',
          foreground: 'hsl(var(--button-foreground))'
        },
		 orange: {
          DEFAULT: '#FF961A',
		 },
		 orangeHover: {
		  DEFAULT: '#E68717',
		 },
		 orangePressed: {
		  DEFAULT: '#BF7114',
		 },
		 orangeDisabled: {
		  DEFAULT: '#FFDEB8',
		 },
		 green: {
		  DEFAULT: '#3EB489',
		 },
		 greenHover: {
		  DEFAULT: '#256C52',
		 },
		 greenPressed: {
		  DEFAULT: '#163F30',
		 },
		 greenDisabled: {
		  DEFAULT: '#8EA69D',
		 },
		 red: {
		  DEFAULT: '#C30016',
		 },
		 redHover: {
		  DEFAULT: '#920011',
		 },
		 redPressed: {
		  DEFAULT: '#58000A',
		 },
		 redDisabled: {
		  DEFAULT: '#ECB0B7',
		 },
        orangeLight: {
          DEFAULT: '#FFBA69',
        },
        orangeDefault: {
		  DEFAULT: '#FFDEB8'
        },
        grayDefault: {
		  DEFAULT: '#BFBFBF',
        },
		 greenDefault: {
		  DEFAULT: '#8EA69D',
        },
  			border: 'hsl(var(--border))',
  			input: 'hsl(var(--input))',
  			ring: 'hsl(var(--ring))',
  			chart: {
  				'1': 'hsl(var(--chart-1))',
  				'2': 'hsl(var(--chart-2))',
  				'3': 'hsl(var(--chart-3))',
  				'4': 'hsl(var(--chart-4))',
  				'5': 'hsl(var(--chart-5))'
  			}
  		}
  	}
  },
  // eslint-disable-next-line no-undef
  plugins: [require('tailwindcss-animate')],
};