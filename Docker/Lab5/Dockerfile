FROM node:24-alpine

WORKDIR /app

COPY package*.json ./

RUN npm install -g npm@latest \
    && npm ci \
    && npm cache clean --force 

COPY app.js ./

EXPOSE 3000

CMD ["npm", "start"]
